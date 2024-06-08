import browser.document
import csstype.*
import emotion.react.css
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.css.BackgroundRepeat
import kotlinx.css.FlexWrap
import kotlinx.html.TEXTAREA
import org.w3c.dom.HTMLTextAreaElement
import react.FC
import react.Props
import react.dom.aria.AriaRole
import react.dom.aria.ariaLabel
import react.dom.html.InputType
import react.dom.html.ReactHTML
import react.dom.html.ReactHTML.a
import react.dom.html.ReactHTML.br
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h1
import react.dom.html.ReactHTML.h2
import react.dom.html.ReactHTML.hr
import react.dom.html.ReactHTML.img
import react.dom.html.ReactHTML.input
import react.dom.html.ReactHTML.p
import react.dom.html.ReactHTML.span
import react.dom.html.ReactHTML.textarea
import react.dom.html.ReactHTML.title
import react.dom.svg.ReactSVG
import react.dom.svg.ReactSVG.rect
import react.dom.svg.ReactSVG.svg
import kotlin.Float
import kotlin.math.pow
import kotlin.text.Typography.nbsp


var AboutMeView = FC<NavProps> { props ->
    div{
        css{
            ww = "100%"
            position = Position.absolute
            top = 0.px
            left = 0.px
            backgroundColor = Color("#F5F5F5")
        }
        id = "locate_1_0"
        //member
        div{

            //title
            var contextD = peopleInfo[0]
            div{
                css{
                    backgroundColor = Color("#E2E2E2")
                    ww = "100%"
                    height = 300.px
                    mm = "200px 0 120px"
                    //display = Display.flex
                }
                div{
                    className = ClassName("container d-flex")
                    img{
                        css{
                            if (props.Decide == "phone") {
                                ww = "40%"
                            }else {
                                height = 300.px
                            }
                            objectFit = ObjectFit.cover
                            mm =  if ( props.Decide == "phone") "0 10px 0 0" else "0 20px"
                        }
                        src = contextD.peopleImage
                    }
                    div{

                        css{
                            mm = if ( props.Decide == "phone") "0" else if ( props.Decide == "paid") "0 20px" else "0 80px"
                            flexWrap = csstype.FlexWrap.wrap
                            height = 300.px
                            display = Display.flex
                            alignContent = AlignContent.center
                        }
                        div {
                            div{
                                css{
                                    mm =  "20px 0"
                                }
                                h1 {
                                    +contextD.name
                                    css{
                                        display = Display.inline
                                        FontFamily = "SourceHanSerif_b"
                                        fontSize = 36.px
                                    }
                                }
                                if (props.Decide != "phone"){
                                    p {
                                        +"${nbsp}${contextD.enName}"
                                        css{
                                            display = Display.inline
                                            FontFamily = "SourceHanSerif_b"
                                            fontSize = 24.px
                                        }
                                    }
                                }

                            }


                            p {
                                css{
                                    FontFamily = "SourceHanSerif_n"
                                    fontSize = 20.px
                                }
                                for (i in contextD.titleForName){
                                    +i
                                    if (props.Decide == "phone"){
                                        br{}
                                    }
                                }
                            }
                            br{}
                            br{}
                            p {
                                +contextD.email
                            }
                            p {
                                +contextD.phone
                            }

                        }
                    }
                }

            }

            //context
            if (props.Decide == "phone"){
                div {
                    className = ClassName("container d-flex justify-content-center")
                    div{
                        css{
                            ww = "95%"
                        }
                        textTitle{
                            context =  listOf(
                                Pair("個人簡介", 12),
                            )
                            linePercent = "98%"
                        }
                        div{
                            css{
                                fontSize = 20.px
                                lineHeight = 40.px
                            }
                            for (i in 0 .. contextD.info.count()-1){
                                p{
                                    +contextD.info[i]
                                }
                            }
                            br{}
                        }

                        textTitle{
                            context =  listOf(
                                Pair("專長", 12),
                            )
                            linePercent = "98%"
                        }
                        div{
                            css{
                                fontSize = 20.px
                                lineHeight = 30.px
                            }
                            for (i in 0 .. contextD.major.count()-1){
                                p{
                                    +contextD.major[i]
                                }
                            }
                            br{}
                        }
                        textTitle{
                            context =  listOf(
                                Pair("學歷", 12),
                            )
                            linePercent = "98%"
                        }
                        div{
                            css{
                                fontSize = 20.px
                                lineHeight = 30.px
                            }
                            for (i in 0 .. contextD.education.count()-1){
                                p{
                                    +contextD.education[i]
                                }
                            }
                            br{}
                        }
                        textTitle{
                            context =  listOf(
                                Pair("經歷", 12),
                            )
                            linePercent = "98%"
                        }
                        div{
                            css{
                                fontSize = 20.px
                                lineHeight = 40.px
                            }
                            for (i in 0 .. contextD.experience.count()-1){
                                p{
                                    +contextD.experience[i]
                                }
                            }
                            br{}
                        }


                    }

                }
            }else{
                div{
                    className = ClassName("container")
                    textTitle{
                        context =  listOf(
                            Pair("個人簡介", 7),
                            Pair("專長",5)
                        )
                        linePercent = "98%"
                    }
                    div{
                        className = ClassName("row")
                        div{
                            className = ClassName("col-7")
                            div{
                                css{
                                    ww = "95%"
                                    fontSize = 20.px
                                    lineHeight = 40.px
                                }
                                for (i in 0 .. contextD.info.count()-1){
                                    p{
                                        +contextD.info[i]
                                    }
                                }
                            }
                        }
                        div{
                            className = ClassName("col-5")
                            div{
                                css{
                                    ww = "95%"
                                    fontSize = 20.px
                                    lineHeight = 30.px
                                }
                                for (i in 0 .. contextD.major.count()-1){
                                    p{
                                        +contextD.major[i]
                                    }
                                }
                                br{}
                            }
                            textTitle{
                                context =  listOf(
                                    Pair("學歷", 12)
                                )
                                linePercent = "${100-(2*12/5)}%"
                            }
                            div{
                                css{
                                    ww = "95%"
                                    fontSize = 20.px
                                    lineHeight = 30.px
                                }
                                for (i in 0 .. contextD.education.count()-1){
                                    p{
                                        +contextD.education[i]
                                    }
                                }
                                br{}
                            }

                        }
                    }
                    br{}
                    br{}
                    textTitle{
                        context =  listOf(
                            Pair("經歷", 12),
                        )
                        linePercent = "98%"
                    }
                    div{
                        css{
                            ww = "95%"
                            fontSize = 20.px
                            lineHeight = 30.px
                        }
                        for (i in 0 .. contextD.experience.count()-1){
                            p{
                                +contextD.experience[i]
                            }
                        }
                        br{}
                    }
                }

            }


        }
        hr {
            id = "locate_1_1"
            css {
                bborder = "2px solid block"
                ww = "100%"
                backgroundColor = Color("F5F5F5")
            }
        }
        //aboutMe
        if (props.Decide == "phone"){
            div {
                var contextD = contactUsDatas[0]
                css {
                    backgroundColor = Color("#F5F5F5")
                }
                div{
                    css{
                        ww = "100%"
                        height = 200.px
                        display = Display.flex
                        justifyContent = JustifyContent.center
                    }
                    h1{
                        css{
                            FontFamily = "SourceHanSerif_b"
                            fontSize = 36.px
                            mm = "100px 0 0"
                        }
                        +"聯絡我們"
                    }
                }
                var contactHeight: Int = props.NowViewHeight
                div{
                    css{
                        backgroundColor = Color("#C3DBED")
                        borderRadius = 16.px
                        mm = "0 1.5% 0% 1.5%"
                        ww = "97%"
                        height = (contactHeight*2/5).px
                    }
                    div{
                        css{
                            display = Display.flex
                            alignItems = AlignItems.center
                            ww = "100%"
                            hh = "20%"
                        }
                        h1{
                            css{
                                position = Position.relative
                                fontSize = 24.px
                                FontFamily = "SourceHanSerif_b"
                                left = 20.px
                                hh = "20%"
                            }
                            +contextD.title
                        }
                    }

                    div{
                        css{
                            display = Display.flex
                            justifyContent = JustifyContent.center
                            alignItems = AlignItems.center
                            ww = "100%"
                            hh = "80%"
                        }
                        div{
                            css{
                                position = Position.relative
                                top = if (props.NowViewHeight > 900) -10.px else 10.px
                                ww = "80%"
                            }

                            for(i in contextD.info){
                                p{
                                    +i
                                }
                            }
                        }
                    }
                    br{}
                    br{}
                    div{
                        css{
                            ww = "100%"
                            display = Display.flex
                            justifyContent = JustifyContent.start
                        }
                        img{
                            src = contextD.imageLoca[0]
                        }
                        div{
                            css {
                                display = Display.flex
                                alignItems = AlignItems.center
                            }
                            div{
                                p{
                                    css{
                                        textAlign = TextAlign.left
                                    }
                                    +"e-mail"
                                }
                                p{
                                    css{
                                        textAlign = TextAlign.left
                                    }
                                    +contextD.email
                                }
                            }

                        }

                    }
                    br{}
                    br{}
                    div{
                        css{
                            ww = "100%"
                            display = Display.flex
                            justifyContent = JustifyContent.start
                        }
                        img{
                            src = contextD.imageLoca[1]
                        }
                        div{
                            css {
                                display = Display.flex
                                alignItems = AlignItems.center
                            }
                            div{
                                p{
                                    css{
                                        textAlign = TextAlign.left
                                    }
                                    +"電話"
                                }
                                p{
                                    css{
                                        textAlign = TextAlign.left
                                    }
                                    +contextD.tel
                                }
                            }

                        }


                    }
                    div{
                        css {
                            ww = "100%"
                            height = 100.px

                        }
                    }

                }

            }

        }else{
            div{
                var contextD = contactUsDatas[0]
                css{
                    height = props.NowViewHeight.px
                }
                //title
                div{
                    css{
                        ww = "100%"
                        height = 200.px
                        display = Display.flex
                        justifyContent = JustifyContent.center
                    }
                    h1{
                        css{
                            FontFamily = "SourceHanSerif_b"
                            fontSize = 36.px
                            mm = "100px 0 0"
                        }
                        +"聯絡我們"
                    }

                }
                //context
                var contactHeight: Int = props.NowViewHeight - if (props.NowViewHeight < 810) 100 else 250//250
                //line one
                div{
                    css {
                        backgroundColor = Color("#F5F5F5")
                    }
                    div{
                        className = ClassName("container")
                        div{
                            css{
                                height = contactHeight.px
                                ww = "100%"
                                display = Display.flex
                                // backgroundColor = Color("#F5F5F5")
                            }
                            div{
                                css{
                                    ww = "50%"
                                    height = contactHeight.px
                                    borderRight = Border(width = 1.px, style = LineStyle.solid, color = Color("#000000"))
                                }
                                div{
                                    css{
                                        backgroundColor = Color("#C3DBED")
                                        borderRadius = 16.px
                                        mm = "0% 3% 0% 0%"
                                        ww = "97%"
                                        height = (contactHeight*2/5).px
                                    }
                                    div{
                                        css{
                                            display = Display.flex
                                            alignItems = AlignItems.center
                                            ww = "100%"
                                            hh = "20%"
                                        }
                                        h1{
                                            css{
                                                position = Position.relative
                                                fontSize = 24.px
                                                FontFamily = "SourceHanSerif_b"
                                                left = 20.px
                                                hh = "20%"
                                            }
                                            +contextD.title
                                        }
                                    }

                                    div{
                                        css{
                                            display = Display.flex
                                            justifyContent = JustifyContent.center
                                            alignItems = AlignItems.center
                                            ww = "100%"
                                            hh = "80%"
                                        }
                                        div{
                                            css{
                                                position = Position.relative
                                                top = if (props.NowViewHeight > 900) -10.px else 10.px
                                                ww = "80%"
                                            }

                                            for(i in contextD.info){
                                                p{
                                                    +i
                                                }
                                            }
                                        }
                                    }

                                }
                                hr{
                                    css{
                                        ww = "100%"
                                        border = Border(width = 1.5.px, style = LineStyle.solid, color = Color("#000000"))
                                    }
                                }
                                div{
                                    css{
                                        ww = "100%"
                                        display = Display.flex
                                        justifyContent = JustifyContent.end
                                    }
                                    div{
                                        css {
                                            display = Display.flex
                                            alignItems = AlignItems.end
                                        }
                                        div{
                                            p{
                                                css{
                                                    textAlign = TextAlign.right
                                                }
                                                +"e-mail"
                                            }
                                            p{
                                                css{
                                                    textAlign = TextAlign.right
                                                }
                                                +contextD.email
                                            }
                                        }

                                    }
                                    img{
                                        src = contextD.imageLoca[0]
                                    }
                                }


                                div{
                                    css{
                                        ww = "100%"
                                        display = Display.flex
                                        justifyContent = JustifyContent.end
                                    }
                                    hr{
                                        css{
                                            ww = "80%"
                                            border = Border(width = 1.5.px, style = LineStyle.solid, color = Color("#000000"))
                                        }
                                    }
                                }
                                div{
                                    css{
                                        ww = "100%"
                                        display = Display.flex
                                        justifyContent = JustifyContent.end
                                    }
                                    div{
                                        css {
                                            display = Display.flex
                                            alignItems = AlignItems.end
                                        }
                                        div{
                                            p{
                                                css{
                                                    textAlign = TextAlign.right
                                                }
                                                +"電話"
                                            }
                                            p{
                                                css{
                                                    textAlign = TextAlign.right
                                                }
                                                +contextD.tel
                                            }
                                        }

                                    }
                                    img{
                                        src = contextD.imageLoca[1]
                                    }
                                }
                                div{
                                    css{
                                        ww = "100%"
                                        display = Display.flex
                                        justifyContent = JustifyContent.end
                                    }
                                    hr{
                                        css{
                                            ww = "60%"
                                            border = Border(width = 1.5.px, style = LineStyle.solid, color = Color("#000000"))
                                        }
                                    }
                                }




                            }
                            div{
                                css{
                                    ww = "50%"
                                    height = contactHeight.px
                                }
                                textarea{
                                    css{
                                        ww = "97%"
                                        height = (contactHeight/2 + 100).px
                                        mm = "3%"
                                        top = 30.px
                                        position = Position.relative
                                    }
                                    placeholder = "輸入訊息"
                                    id = "textInput"
                                }
                                button {
                                    css{
                                        mm = "25px 25px 25px 3%"
                                        backgroudforImage = "#C3DBED"
                                        borderRadius = 16.px
                                        width = 167.px
                                        height = 59.px
                                        border = 0.px
                                        // borderColor = Color("#FFFFFF")
                                    }
                                    +"確認"
                                    onClick = {
                                        var aa = document.getElementById("textInput") as? dom.html.HTMLTextAreaElement
                                        //pool.getConncetion
                                        /*
                                        val mainScope = MainScope()
                                        mainScope.launch {
                                            console.log("launch123")
                                            my()
                                        }

                                         */
                                        aa?.let{
                                            it.value = ""
                                        }

                                    }
                                }

                            }

                        }

                    }

                }
            }

        }
    }
    /*
    div {
        className = ClassName("position-fixed bottom-0 end-0 mb-3 me-3")
        id = "forTest"
        p {
            css {
                color = Color("red")

            }
            +"d: ${props.Decide}"

        }
    }

     */
}
var textTitle = FC<textTitleProps>{ props ->
    div{
        div{
            className = ClassName("row")
            for(i in props.context){
                div{
                    className = ClassName("col-${i.second}")
                    h1{
                        css{
                            FontFamily = "SourceHanSerif_b"
                            fontSize = 24.px
                        }
                        +i.first
                    }

                }
            }
        }
        div{
            css{
                display = Display.flex
                justifyContent = JustifyContent.center
            }
            hr {
                css {

                    bborder = "1.5px solid #000000"
                    ww = props.linePercent
                }
            }
        }

    }
}
external interface textTitleProps : Props {
    var context: List<Pair<String,Int>> //name & Grid
    var linePercent: String
}

data class memberData (
    var name: String,
    var phone: String = "",
    var enName: String = "",
    var email: String = "",
    var titleForName: List<String> = listOf(),
    var peopleImage: String,
    var info: List<String> = listOf(),
    var education: List<String> = listOf(),
    var experience: List<String> = listOf(),
    var major: List<String> = listOf(),
    var keyID: Int,
)

data class ContactUsData (
    var title: String = "",
    var info: List<String> = listOf(),
    var email: String = "",
    var tel: String = "",
    var imageLoca: List<String> = listOf(),
)

var peopleInfo: List<memberData> = listOf(
    memberData(
        name = "黃皓淵",
        phone = "0910817523",
        enName = "Huang Hao-Yuan",
        email = "oscar771209555@gamil.com",
        titleForName = listOf<String>("東華大學應用數學系博士", "ＮaNa創辦人"),
        peopleImage = "drawable/oscar.JPG",
        info = listOf<String>("明明臨床心理系畢業碩士卻唸了應用數學，中間曾經寫過小說，去過澳洲，在山上的小鎮一間中國人開的按摩店裡工作了一年。然後回來繼續寫，堅持什麼呢？其中有宛如神明般的小羊拐走了姊姊的親弟，也有殺死了自己的創造者最後被流放到地球的超先進古文明，大概就是像這樣的故事吧。",
                "",
                "什麼？你問這一切是怎麼跟數學扯上關係的？為了維持生計，我必須到一間補習班打工，因此就複習了國小、國中、高中的數學，接著便學了微積分，緊接著就在大學裡試圖搞懂高等微積分跟測度論了。",
                "",
                "或許與你又會想問，最後我又是怎麼學會右上角那些東東的？可是要詳述怎麼跟著教授一步一步學習類神經網路、從不懂程式到明白Ｍatlab、Swift還有等等的一切，就真的太漫長了。想說的只是，原本真心以為小說會這麼一直寫下去的。",
                "",
                "不過這樣倒也不賴。",
        ),

        education = listOf(
            "．輔仁大學臨床心理系學士",
            "．東華大學應用數學系碩士",
            "．東華大學應用數學系博士（就讀中）"
        ),
        experience = listOf(
            "．參與產學合作計畫『藍芽聽診器音訊分析的iOS APP實作與心音辨識應用",
            "．參與產學合作計畫『iCloud雲端資料庫存取與即時拜訪路徑最佳化 』",
            "．iOS app『暢遊花蓮』開發者（可於 Apple App Store下載）",
            "．國衛院 app『行醫記錄器』更新至iOS 17（新版本僅供研究人員由特定網址下載）",
            "．2020年於美國在台協會（American Institute in Taiwan）舉辦的「程式少女特訓營」當中當任活動講師"
        ),
        major = listOf(
            "．iOS${nbsp}android${nbsp}App設計",
            "．UI介面設計",
            "．網頁前端與後端設計",
            "．聲音${nbsp}視覺辨識"
        ),
        keyID = 1


    ))
var contactUsDatas: List<ContactUsData> = listOf(
    ContactUsData(
        title = "關於NaNa",
        info = listOf<String>("很簡單，家裡有隻黑貓叫做NaNa，" ,
                "因為很喜歡，因此工作室便也就如此稱呼了。" ,
                "NaNa有著甜美的嗓音，很懂得利用自己的優勢換取被用罐罐餵食，" ,
                "希望我們也能如此這般，獲得各位持續的支持。"
        ),
        email = "oscar771209555@gmail.com",
        tel = "0910-817-523",
        imageLoca = listOf(
            "drawable/email.png",
            "drawable/phone.png",
            "drawable/my_mark.svg",
        )
    )
)