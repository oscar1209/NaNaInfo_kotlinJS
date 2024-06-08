import csstype.*
import dom.events.WheelEvent
import dom.html.HTML.img
import emotion.react.css
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.css.header
import kotlinx.css.span
import kotlinx.html.Entities
import kotlinx.html.STYLE
import kotlinx.html.org.w3c.dom.events.Event
import kotlinx.serialization.Serializable
import react.FC
import react.Props
import react.dom.aria.*
import react.dom.html.ButtonType
import react.dom.html.HTMLAttributes
import react.dom.html.ReactHTML
import react.dom.html.ReactHTML.a
import react.dom.html.ReactHTML.br
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h1
import react.dom.html.ReactHTML.header
import react.dom.html.ReactHTML.img
import react.dom.html.ReactHTML.li
import react.dom.html.ReactHTML.main
import react.dom.html.ReactHTML.nav
import react.dom.html.ReactHTML.span
import react.dom.html.ReactHTML.ul
import react.dom.svg.ReactSVG
import react.dom.svg.SVGAttributes
import react.useState

/*
var font = FC<FontProps>{
    +"${it.text}"



}
external interface FontProps : Props {
    var text: String

}

 */

val heightLimits: Int = 710 //810
var hc: Int = 0
//var speed : Int = 2
//val nowViewHeight: Int = 1
//val wordColor: String = "0xffFF1D7F"
var paid2desktop = 1150.0 //響應式設計
var phone2paid = 992.0 //響應式設計 //響應式設計

val App = FC<Props> {
    var stateControl  by useState<Pair<Int, Int>>(Pair(0, 0))
    var w: Int by useState<Int>(window.innerWidth)
    var h: Int by useState<Int>(window.innerHeight)
    var decide: String by useState(if (w > paid2desktop) "desktop" else if (w>phone2paid) "paid" else "phone")
    var nowViewHeight: Int by useState<Int>((if(h>=heightLimits) h else heightLimits) - hc )
    var action: Boolean by useState<Boolean>(true)
    var eventSet: MutableSet<(Event)->Unit> by useState(mutableSetOf())
    var eventSetRe: MutableSet<(Event)->Unit> by useState(mutableSetOf())
    var sWheel: (Int,Int) -> Unit = { aa , bb ->
            val speed = 1500
            console.log("locate_${aa}_${bb}")
            document.getElementById("locate_${aa}_${bb}")?.apply {
               // console.log(jq("#locate_0_${it}").offset().top)
                var a: dynamic = object{}
                a["scrollTop"] = jq("#locate_${aa}_${bb}").offset().top
                jq("html, body").stop(true).animate(a,speed,{
                    action = true
                    console.log("action to ${action}")
                })
            }?:run{
                window.setTimeout({
                    document.getElementById("locate_${aa}_${bb}")?.apply {
                       // console.log(jq("#locate_0_${it}").offset().top)
                        var a: dynamic = object{}
                        a["scrollTop"] = jq("#locate_${aa}_${bb}").offset().top
                        jq("html, body").stop(true).animate(a,speed,{
                            action = true
                            console.log("action to ${action}")
                        })
                    }
                },500)
            }

    }
    var resizeEvent: (Event)->Unit = {
        if (w != window.innerWidth){
            w = window.innerWidth
            decide = if (w > paid2desktop) "desktop" else if (w>phone2paid) "paid" else "phone"
        }
        if (h != window.innerHeight){
            h = window.innerHeight
            if(h>=heightLimits){
                nowViewHeight = h - hc
            }else{
                nowViewHeight = heightLimits - hc
            }
        }

    }
    var wheelEvent: (Event)->Unit = {
        var ii = it as WheelEvent
        it.preventDefault()
        //console.log(ii.deltaY)
        if (action && Math.abs(ii.deltaY) > 30){
            if (stateControl.second == 0){
                if (ii.deltaY > 0){
                    action = false
                    stateControl = Pair(0,stateControl.second+1)
                }
            }else if (stateControl.second == 4){
                if (ii.deltaY < 0){
                    action = false
                    stateControl = Pair(0,stateControl.second-1)
                }
            }else{
                if (ii.deltaY > 0){
                    action = false
                    stateControl = Pair(0,stateControl.second+1)
                }
                if (ii.deltaY < 0){
                    action = false
                    stateControl = Pair(0,stateControl.second-1)
                }
            }
        }
    }
    if (decide != "phone"){
        if (!eventSetRe.contains(resizeEvent)){
            window.addEventListener("resize", resizeEvent)
        }
    }

    if (stateControl.first == 0 && decide != "phone"){


        document.getElementById("root")?.apply {
            if (!eventSet.contains(wheelEvent)){

                eventSet.add(wheelEvent)
                this.addEventListener("wheel", wheelEvent)
            }
        }
        sWheel(stateControl.first,stateControl.second)

    }
    if (stateControl.first == 1){

        document.getElementById("root")?.apply {
            for (i in eventSet) {
                this.removeEventListener("wheel", i)
            }
        }
        eventSet.removeAll({
            true
        })
        console.log("there")
        console.log(eventSet.size)
        sWheel(stateControl.first,stateControl.second)

    }
    if(decide == "phone"){

        for (i in eventSetRe) {
            window.removeEventListener("resize", i)
        }
        document.getElementById("root")?.apply {
            for (i in eventSet) {
                this.removeEventListener("wheel", i)
            }
        }
        eventSet.removeAll({
            true
        })
        eventSetRe.removeAll({
            true
        })
        //nowViewHeight = 720
        console.log("there")
        console.log(eventSet.size)
        sWheel(stateControl.first,stateControl.second)
    }

    Nav{

        handle = {
            stateControl = it
        }
    }
    main {
        if (stateControl.first == 0) {
            InfoPageView {
                maxWidth = w
                maxHeight = h
                NowViewHeight = nowViewHeight
                handle = {
                    stateControl = it
                }
                Decide = decide
            }
        }
        if (stateControl.first == 1) {
            AboutMeView{
                maxWidth = w
                maxHeight = h
                NowViewHeight = nowViewHeight
                handle = {
                    stateControl = it
                }
                Decide = decide
            }
        }



    }
/*
    div{

        className = ClassName("position-fixed bottom-0 end-0 mb-3 me-3")
        h1 {
            css{
                color = Color("red")
            }
            +"w:${w} h:${h} "
            br {}
            +"nowh:${nowViewHeight}"
            br {}
            +"Control: ${stateControl}"
            br {}
            +"device: ${decide}"
        }
    }

 */


    //var w = container.clientWidth
    // var h = container.clientHeight

}

external interface NavProps : Props {
    var maxWidth: Int
    var maxHeight: Int
    var NowViewHeight: Int
    var handle: (Pair<Int, Int>)->Unit
    var Decide: String


}

var Nav = FC<NavProps>{props ->
    header{
        BdataBsTheme="dark"
        nav{
            className = ClassName("navbar navbar-expand-md navbar-dark fixed-top bg-dark bg-opacity-75")
            div{
                className = ClassName("container-fluid")


                a() {
                    className = ClassName("navbar-brand")
                    role = AriaRole.button

                    span{

                        css {
                            marginInlineStart = 34.px
                            FontFamily = "SmileySans"
                        }

                        +" NaNa STUDIO"
                    }
                    onClick = {
                        props.handle(Pair(0,0))
                    }

                }
                button() {
                    className = ClassName("navbar-toggler")
                    type = ButtonType.button
                    dataBsToggle = "collapse"
                    dataBsTarget = "#navbarCollapse"
                    AriaControls = "navbarCollapse"
                    AriaExpanded = "false"
                    ariaLabel = "Toggle navigation"
                    span{
                        className = ClassName("navbar-toggler-icon")
                    }


                }

                div(){
                    className = ClassName("collapse navbar-collapse")
                    id = "navbarCollapse"
                    ul{
                        className = ClassName("navbar-nav me-auto mb-2 mb-md-0")
                        li{
                            className = ClassName("nav-item dropdown me-2")
                            a{
                                className = ClassName("nav-link dropdown-toggle")
                                id="navbarDropdown"
                                // href=""
                                role = AriaRole.button
                                dataBsToggle = "dropdown"
                                AriaExpanded = "false"
                                ariaHaspopup = "true"
                                // AriaCurrent = "page"
                                +"介紹"
                            }
                            div{
                                className = ClassName("dropdown-menu")
                                ariaLabelledby = "navbarDropdown"
                                a{
                                    className = ClassName("dropdown-item")
                                    role = AriaRole.button
                                    onClick = {
                                        props.handle(Pair(0,1))

                                    }
                                    +"介紹1"
                                }
                                a{
                                    className = ClassName("dropdown-item")
                                    //  role = AriaRole.button
                                    role = AriaRole.button
                                    onClick = {
                                        props.handle(Pair(0,2))
                                    }
                                    +"介紹2"
                                }
                                a{
                                    className = ClassName("dropdown-item")
                                    //   role = AriaRole.button
                                    onClick = {
                                        props.handle(Pair(0,3))
                                    }
                                    role = AriaRole.button
                                    +"介紹3"
                                }

                            }

                        }
                        li{
                            className = ClassName("nav-item me-2")
                            a{
                                className = ClassName("nav-link active")
                                role = AriaRole.button
                                onClick = {
                                    props.handle(Pair(0,4))
                                    console.log("locate_0_4")
                                }
                                +"作品"
                            }

                        }
                        li{
                            className = ClassName("nav-item me-2")
                            a{
                                className = ClassName("nav-link active")
                                role = AriaRole.button
                                onClick = {
                                    props.handle(Pair(1,0))
                                }
                                +"成員"
                            }

                        }
                        li{
                            className = ClassName("nav-item me-2")
                            a{
                                className = ClassName("nav-link active")
                                role = AriaRole.button
                                onClick = {
                                    props.handle(Pair(1,1))
                                }
                                +"聯絡我們"
                            }

                        }

                    }
                }


            }

        }
    }

}


val OtherApp = FC<Props> {



    ReactHTML.div() {
        className = ClassName("dropdown position-fixed bottom-0 end-0 mb-3 me-3 bd-mode-toggle")
        ReactHTML.button {
            className = ClassName("btn btn-bd-primary py-2 dropdown-toggle d-flex align-items-center")
            id = "bd-theme"
            type = ButtonType.button
            ariaExpanded = false
            dataBsToggle = "dropdown"
            ariaLabel = "Toggle theme (auto)"
            ReactSVG.svg() { // id = "svg1"
                className = ClassName("bi my-1 theme-icon-active")
                widthEm = "1em"
                heightEm = "1em"//"1em"
                ReactSVG.use {
                    href = "#circle-half"
                }
            }

            ReactHTML.span() {
                className = ClassName("visually-hidden")
                id = "bd-theme-text"
                //+"""Toggle theme"""
            }
        }
        ReactHTML.ul() {
            className = ClassName("dropdown-menu dropdown-menu-end shadow")
            ariaLabelledBy = "bd-theme-text"
            ReactHTML.li {
                ReactHTML.button() {
                    className = ClassName("dropdown-item d-flex align-items-center")
                    type = ButtonType.button
                    ariaPressed = AriaPressed.`false`
                    BdataBsThemeValue = "light"
                    ReactSVG.svg() {
                        className = ClassName("bi me-2 opacity-50")
                        widthEm = "1em"
                        heightEm = "1em"//"1em"
                        ReactSVG.use {
                            href = "#sun-fill"
                        }
                    }
                    +"""Light"""
                    ReactSVG.svg() {
                        className = ClassName("bi ms-auto d-none")
                        widthEm = "1em"
                        heightEm = "1em"//"1em"
                        ReactSVG.use {
                            href = "#check2"
                        }
                    }
                }
            }
            ReactHTML.li {
                ReactHTML.button() {
                    className = ClassName("dropdown-item d-flex align-items-center")
                    type = ButtonType.button
                    ariaPressed = AriaPressed.`false`
                    BdataBsThemeValue = "dark"

                    ReactSVG.svg() {
                        className = ClassName("bi me-2 opacity-50")
                        widthEm = "1em"
                        heightEm = "1em"//"1em"
                        ReactSVG.use {
                            href = "#moon-stars-fill"
                        }
                    }
                    +"""Dark"""
                    ReactSVG.svg() {
                        className = ClassName("bi ms-auto d-none")
                        widthEm = "1em"
                        heightEm = "1em"//"1em"
                        ReactSVG.use {
                            href = "#check2"
                        }
                    }
                }
            }
            ReactHTML.li {
                ReactHTML.button() {
                    className = ClassName("dropdown-item d-flex align-items-center")
                    type = ButtonType.button
                    BdataBsThemeValue = "auto"

                    ariaPressed = AriaPressed.`true`
                    ReactSVG.svg() {
                        className = ClassName("bi me-2 opacity-50")
                        widthEm = "1em"
                        heightEm = "1em"//"1em"
                        ReactSVG.use {
                            href = "#circle-half"
                        }
                    }

                    +"""Auto"""
                    ReactSVG.svg() {
                        className = ClassName("bi ms-auto d-none")
                        widthEm = "1em"
                        heightEm = "1em"//"1em"
                        ReactSVG.use {
                            href = "#check2"
                        }
                    }
                }
            }
        }
    }

}