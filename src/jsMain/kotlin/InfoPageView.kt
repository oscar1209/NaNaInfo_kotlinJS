import csstype.*
import emotion.react.css
import kotlinx.css.BackgroundRepeat
import react.FC
import react.dom.aria.AriaRole
import react.dom.aria.ariaLabel
import react.dom.html.ReactHTML
import react.dom.html.ReactHTML.a
import react.dom.html.ReactHTML.br
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h1
import react.dom.html.ReactHTML.h2
import react.dom.html.ReactHTML.hr
import react.dom.html.ReactHTML.img
import react.dom.html.ReactHTML.p
import react.dom.html.ReactHTML.span
import react.dom.html.ReactHTML.title
import react.dom.svg.ReactSVG
import react.dom.svg.ReactSVG.rect
import react.dom.svg.ReactSVG.svg
import kotlin.Float
import kotlin.math.pow
import kotlin.text.Typography.nbsp



var InfoPageView = FC<NavProps> { props ->


    div {
        css {
            ww = "100%"
            position = Position.absolute
            if(props.Decide != "phone") {
                height = (props.NowViewHeight * 5).px
            }
            top = 0.px
            left = 0.px
            backgroundColor = Color("#000000")
            overflow = Overflow.hidden
        }

        //0-----------------------------------------------------------------------
        div {
            id = "locate_0_0"
            css {
                ww = "100%"
                // position = Position.absolute
                if(props.Decide != "phone") {
                    height = props.NowViewHeight.px
                }

            }
            var imageHeight = (props.NowViewHeight.toDouble() * 5 / 9)
            if (props.NowViewHeight < 810 && props.Decide != "phone") {
                imageHeight = (props.NowViewHeight.toDouble() * 4 / 9)
            }
            div {
                css {
                    ww = "100%"
                    position = Position.relative
                    height = imageHeight.px
                    backgroudforImage = "url(drawable/background.png)"
                    backgroundSize = BackgroundSize.cover
                    backgroundRepeat = csstype.BackgroundRepeat.noRepeat
                }
                id = "background"
                ReactHTML.h1 {
                    css {
                        color = Color("#ffffff")
                        pp = "${imageHeight * 4 / 10}px 0 0 50px"
                        FontFamily = "SourceHanSerif_b"
                        fontSize = 25.px
                        lineHeight = 40.px
                    }
                    +"迅捷  "
                    br {}
                    +"${nbsp}${nbsp}有效"
                    br {}
                    br {}

                    if (props.NowViewHeight > 810) {

                        br {}
                        br {}
                    }

                    if (props.Decide == "phone"){
                        +"iOS android Web "
                        br {}
                        +"智慧解決方案"
                    }else{
                        +"iOS android Web 智慧解決方案"
                    }


                }
            }

            var contentHeight = (props.NowViewHeight.toDouble() * 4 / 9)
            if (props.NowViewHeight < 810 && props.Decide != "phone"){
                contentHeight = (props.NowViewHeight.toDouble() * 5 / 9)
            }

            div {
                css {
                    ww = "100%"
                    if(props.Decide != "phone"){
                        height = contentHeight.px
                    }
                    color = Color("#ffffff")
                }
                div {
                    className = ClassName("container-fluid marketing")
                    div {
                        className = ClassName("row")
                        for (i in forTitleData) {
                            div {
                                className = ClassName("col-lg-4 pt-${i.padding}")
                                if (props.Decide != "phone") {
                                    img {
                                        className = ClassName("bd-placeholder-img")
                                        width = contentHeight / 2 * i.imageScale
                                        height = contentHeight / 2 * i.imageScale
                                        src = i.textImage
                                    }
                                    h2 {
                                        id = "title"
                                        className = ClassName("fw")
                                        +i.title
                                    }


                                    p {
                                        id = "textContext-${i.keyID}"
                                        className = ClassName("mx-auto")
                                        +i.textContext
                                    }

                                    p {
                                        a {
                                            className = ClassName("btn btn-secondary")
                                            +"了解更多"
                                            role = AriaRole.button
                                            onClick = {
                                                // console.log(i.keyID)
                                                props.handle(Pair(0, i.keyID))
                                            }
                                        }

                                    }
                                }else{
                                    div{
                                        className = ClassName("col-lg-4")
                                        div{
                                            css{
                                                display = Display.flex
                                                justifyContent = JustifyContent.center
                                                textAlign = TextAlign.left
                                                height = 20.px
                                            }
                                            h2 {
                                                css{
                                                    ww = "100%"
                                                    color = Color("#FF1D7F")
                                                    FontFamily = "SourceHanSerif_b"

                                                }
                                               //id = "title"
                                                //className = ClassName("fw")
                                                +"．${i.title}"
                                                role = AriaRole.button
                                                onClick = {
                                                    // console.log(i.keyID)
                                                    props.handle(Pair(0, i.keyID))
                                                }
                                            }
                                            /*
                                            p {
                                                css{
                                                    ww = "30%"
                                                    textAlign = TextAlign.right
                                                }
                                                a {
                                                    className = ClassName("btn btn-secondary")
                                                    +"了解更多"
                                                    role = AriaRole.button
                                                    onClick = {
                                                        // console.log(i.keyID)
                                                        props.handle(Pair(0, i.keyID))
                                                    }
                                                }

                                            }

                                             */

                                        }
                                    }

                                }






                            }

                        }
                    }

                }
            }

        }
        //0end-----------------------------------------------------------------------
        if(props.Decide == "phone"){
            div{
                className = ClassName("container")
                for(i in 0..3){
                    div{
                        id = "locate_0_${i+1}"
                        var contextD = forContextData[i]
                        img{
                            css{
                                ww = "100%"
                                mm = "150px auto 20px"
                            }
                            src = contextD.textImage
                        }
                        h1{
                            css{
                                color = Color("#FF1D7F")
                                FontFamily = "SourceHanSerif_b"
                                fontSize = 24.px
                                lineHeight = 36.px
                                mm = "10px auto"
                                textAlign = TextAlign.center
                            }
                            +"${contextD.title}"
                        }
                        p{
                            css{
                                color = Color("#ffffff")
                                FontFamily = "SourceHanSerif_n"
                                fontSize = 22.px
                                lineHeight = 40.px
                                mm = "10px auto 150px"
                            }
                            for(j in 0 .. contextD.textContext.count()-1){
                                +"${contextD.textContext[j]}"
                                br{}
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

                    +"nowHeight: ${props.NowViewHeight}"

                }
            }

             */
        }else{
            //中間元素以絕對位置做計算Blue_Top & Blue_Bottom-----------------------------------------------------
            var showMaxWidth: Double = 2000.0
            var shiftText: Double = 60.0
            var back: Double =
                if (props.maxWidth > showMaxWidth) 0.0 else ((showMaxWidth - props.maxWidth) * (props.NowViewHeight) / 5500)
            var imageHeight: Double = (props.NowViewHeight * (2.3 / 3)) - back
            var nowWidth: Double = if (props.maxWidth > showMaxWidth) showMaxWidth else props.maxWidth.toDouble()
            var push: Double = if ((props.maxWidth - nowWidth) / 2 > 0) (props.maxWidth - nowWidth) / 2 else 0.0
            var topAllPush: Double =
                if (push + (imageHeight * 0.5 / 3) - back > 0) push + (imageHeight * 0.5 / 3) - back else 0.0
            var yry: Double = (imageHeight * 1 / 5)
            var p: Double = props.maxWidth - topAllPush - yry
            var xrx: Double = (imageHeight * 1.5)
            var bottomAllPush = p - xrx
            var addTopAllPush: Double = if (topAllPush > 40) topAllPush else 40.0

            var bottomTextPush: Double = (props.maxWidth - bottomAllPush) / 20

            var bottomRate: Double = 103.0 / 801.0
            var bottomUpTextPush: Double = (imageHeight * bottomRate)

            var textMaxWidth: Double = 600.0
            var z: Double = (props.maxWidth - topAllPush) * 1 / 3//與yry的距離
            var textPush: Double = p - z - textMaxWidth
            var slope: Double = (445.0 / 3092.0)
            var textTopPush: Double = ((((props.maxWidth - topAllPush) * 1 / 3) + textMaxWidth / 2) * slope)

            var useCos: Double = 1224.0 / (1224.0.pow(2) + 103.0.pow(2)).pow(0.5)
            var stopArea: Double = bottomAllPush + (textMaxWidth * useCos) + 40.0

            //ush + if (maxWidth > 1131.dp) maxWidth-1131.dp else 0.dp
            var upContext: Double = (props.NowViewHeight - (imageHeight * 0.45))

            //間隔線
            for (i in 1..4) {
                hr {
                    css {
                        position = Position.absolute
                        top = (props.NowViewHeight * i - 18).px
                        left = 0.px
                        bborder = "2px solid white"
                        ww = "100%"
                    }
                }
            }
            //中間圖形元素的位置計算------------------------------------------------------------------------------------------------------------------

            //------------------------------------------------------------------------------------------------------------------
            var contextD = forContextData[1]
            //上圖片
            img {
                css {
                    position = Position.absolute
                    height = imageHeight.px
                    top = (props.NowViewHeight + upContext).px
                    right = topAllPush.px
                    Zindex = "1"


                }
                src = forContextData[1].backgroundImage[0]

            }

            //下圖片
            img {
                css {
                    position = Position.absolute
                    height = imageHeight.px
                    top = (props.NowViewHeight + upContext + imageHeight + (props.NowViewHeight + back * 5) / 10).px
                    left = bottomAllPush.px
                    Zindex = "2"
                }
                src = forContextData[1].backgroundImage[1]

            }
            //中圖片
            if (props.maxWidth - addTopAllPush - stopArea > 350 && props.NowViewHeight > 830) { //stopArea
                img {
                    css {
                        position = Position.absolute
                        width = textMaxWidth.px
                        right = (addTopAllPush).px
                        top = (props.NowViewHeight + upContext + imageHeight + (props.NowViewHeight + back * 5) / 8).px
                        Zindex = "5"
                    }
                    src = forContextData[1].textImage
                }
            }
            //上斜文字
            h1 {
                css {
                    position = Position.absolute
                    top = (props.NowViewHeight + upContext + imageHeight - textTopPush - if(props.NowViewHeight<810) 50 else 120).px
                    left = textPush.px
                    fontSize = 24.px
                    lineHeight = 48.px
                    FontFamily = "SourceHanSerif_b"
                    transform = rotate(8.deg)
                    Zindex = "6"
                    //color = Color("#FF1D7F")
                }
                +"${contextD.moreTextContext[0]}"
                br {}
                +"${contextD.moreTextContext[1]}"
            }
            //中文字
            h1 {
                css {
                    position = Position.absolute
                    top = (props.NowViewHeight + upContext + imageHeight + (props.NowViewHeight + back * 5) / 20 - 16).px
                    right = addTopAllPush.px
                    fontSize = 32.px
                    FontFamily = "SourceHanSerif_b"
                    FontFamily = "SourceHanSerif_b"
                    Zindex = "7"
                }
                +"${contextD.title}"
            }
            //下斜文字
            h1 {
                css {
                    position = Position.absolute
                    top =
                        (props.NowViewHeight + upContext + imageHeight + (props.NowViewHeight + back * 5) / 10 + bottomUpTextPush).px
                    left = (bottomAllPush + bottomTextPush).px
                    fontSize = 24.px
                    lineHeight = 48.px
                    FontFamily = "SourceHanSerif_b"
                    transform = rotate((-5).deg)
                    Zindex = "8"
                    //color = Color("#FF1D7F")
                }
                +"${contextD.moreTextContext[2]}"
                br {}
                +"${contextD.moreTextContext[3]}"
            }


            //Blue_Top & Blue_Bottom end-------------------------------------------------
            //去除中間元素的其他畫面
            for (i in 0..3) {
                contextD =  forContextData[i]
                div {
                    id = "locate_0_${i+1}"
                    css {
                        height = props.NowViewHeight.px
                        if (i == 1) {
                            backgroundColor = Color("#ffffff")
                        }


                    }
                    if(i == 0){
                        div{
                            className = ClassName("row h-100 align-items-center")
                            div{
                                className = ClassName("col-lg-6")
                                p{
                                    css{
                                        position = Position.relative
                                        color = Color("#FF1D7F")
                                        FontFamily = "SourceHanSerif_b"
                                        fontSize = 24.px
                                        lineHeight = 48.px
                                        mm = "-20px 0 0 auto"
                                        if (nowWidth / 2 - 25.0 - shiftText < textMaxWidth + 30.0) {
                                            right = 20.px
                                        }else{
                                            right = 50.px
                                        }

                                        width = textMaxWidth.px
                                        Zindex = "4"
                                    }
                                    +contextD.textContext[0]
                                    if (contextD.textContext.count() > 1){
                                        for (j in 1 .. contextD.textContext.count()-1){
                                            br{}
                                            +contextD.textContext[j]
                                        }
                                    }

                                }

                            }
                            div{
                                className = ClassName("col-lg-6 px-0")


                                h1 {
                                    css {
                                        color = Color("#ffffff")
                                        fontSize = 32.px
                                        FontFamily = "SourceHanSerif_b"
                                        mm = "-20px 0 40px"
                                    }
                                    +contextD.title
                                }
                                img {
                                    css {
                                        width = textMaxWidth.px
                                        Zindex = "3"
                                        position = Position.relative
                                    }
                                    src = contextD.textImage
                                }


                            }
                        }
                    }
                    if(i == 2){
                        div{
                            className = ClassName("row h-100 align-items-center")
                            div{
                                className = ClassName("col-lg-6  px-0")
                                div{
                                    css{
                                        position = Position.relative
                                        width = textMaxWidth.px
                                        mm = "20px 0 0 auto"
                                    }
                                    img{
                                        css{
                                            position = Position.relative
                                            width = textMaxWidth.px
                                            Zindex = "3"
                                            position = Position.relative
                                            right = 0.px
                                           // mm = "20px 0 0"
                                        }
                                        src = contextD.textImage
                                    }
                                    h1{
                                        css{
                                            position = Position.relative
                                            color = Color("#ffffff")
                                            fontSize = 32.px
                                            right = 0.px
                                            FontFamily = "SourceHanSerif_b"
                                            width = textMaxWidth.px
                                           mm = "40px 0 0"
                                            textAlign = TextAlign.right
                                        }
                                        +contextD.title
                                    }
                                }

                            }
                            div{
                                className = ClassName("col-lg-6")
                                p{
                                    css{
                                        position = Position.relative
                                        color = Color("#FF1D7F")
                                        FontFamily = "SourceHanSerif_b"
                                        fontSize = 24.px
                                        lineHeight = 48.px
                                       // mm = "20px auto 0 0"
                                        if (nowWidth / 2 - 25.0 - shiftText < textMaxWidth + 30.0) {
                                            left = 20.px
                                        }else{
                                            left = 50.px
                                        }

                                        width = textMaxWidth.px
                                        Zindex = "4"
                                    }
                                    +contextD.textContext[0]
                                    if (contextD.textContext.count() > 1){
                                        for (j in 1 .. contextD.textContext.count()-1){
                                            br{}
                                            +contextD.textContext[j]
                                        }
                                    }

                                }
                            }
                        }
                    }
                    if(i == 3){
                        var total_width = (nowWidth - 400) / 2
                        div{
                            className = ClassName("row h-100 align-items-center")
                            div{
                                className = ClassName("col-lg-6 px-0")
                                div{
                                    css{
                                        position = Position.relative
                                        mm = "0 0 0 auto"

                                        width = 592.px
                                    }
                                    img{
                                        css{
                                            mm = "0 20px 0"
                                            //width = ((total_width - 80) / 2).px
                                        }
                                        src = contextD.backgroundImage[0]
                                    }
                                    img{
                                        css{
                                            mm = "0 20px 0"
                                            //width = ((total_width - 80) / 2).px
                                        }
                                        src = contextD.backgroundImage[1]
                                    }
                                }
                            }
                            div{
                                className = ClassName("col-lg-6")
                                div{
                                    css{
                                        color = Color("#FF1D7F")
                                        FontFamily = "SourceHanSerif_b"
                                        fontSize = 20.px
                                        lineHeight = 37.px
                                        position = Position.relative
                                        left = 20.px
                                        width = total_width.px
                                    }
                                    for (i in 0 .. 2){
                                        h1{
                                            +contextD.textContext[i]
                                        }
                                    }
                                    div{
                                        css{
                                            width = nowWidth.px
                                            display = Display.flex
                                            alignItems = AlignItems.flexStart
                                        }
                                        img{
                                            css{
                                                mm = "25px 25px 25px 0"

                                            }
                                            src = contextD.backgroundImage[2]
                                        }
                                        a{
                                            button {
                                                css{
                                                    mm = "25px 25px 25px 0"
                                                    backgroudforImage = "#C3DBED"
                                                    borderRadius = 16.px
                                                    width = 167.px
                                                    height = 59.px
                                                    border = 0.px
                                                }
                                                +contextD.moreTextContext[1]
                                            }
                                            href = "https://apps.apple.com/tw/app/%E6%9A%A2%E9%81%8A%E8%8A%B1%E8%93%AE/id6455260456"
                                        }


                                    }

                                    h1{
                                        css{
                                            color = Color("#ffffff")
                                            FontFamily = "SourceHanSerif_b"
                                            fontSize = 36.px

                                        }
                                        +contextD.moreTextContext[0]
                                    }
                                    img{
                                        css{
                                            mm = "10px 10px 10px 0"
                                        }
                                        src = contextD.backgroundImage[3]
                                    }

                                }
                            }
                        }
                    }
                }
            }
            //end去除中間元素的其他畫面
            /*
            div {
                className = ClassName("position-fixed bottom-0 end-0 mb-3 me-3")
                id = "forTest"
                p {
                    css {
                        color = Color("red")

                    }
                    +"maxWidth: ${props.maxWidth}"
                    br {}
                    +"nowWidth: ${nowWidth}"
                    br {}
                    +"nowHeight: ${props.NowViewHeight}"
                    br{}
                    +"back: ${back}"
                }
            }

             */





        }





    }
}


data class ContextData(
    var title: String,
    var textContext: List<String> = listOf<String>(),
    var moreTextContext: List<String> = listOf<String>(),
    var textImage: String,
    var backgroundImage: List<String>,
    var keyID: Int
)

data class titleData(
    var title: String,
    var textContext: String,
    var textImage: String,
    var imageScale: Float = 1f,
    var padding: String = "0",
    var keyID: Int
)

val forTitleData = listOf(
    titleData(
        title = "以原生語言進行堆疊式設計",
        textContext = "iOS以及 android 原生語言進行堆疊式設計，共享相同的語言邏輯，兼具高效率、客製化、容易維護的特性",
        textImage = "drawable/building_blocks_re_5ahy.svg",
        padding = "4",
        keyID = 1
    ),
    titleData(
        title = "優秀的UI設計及專業諮詢",
        textContext = "優秀的圖形介面設計，全方位的一對一專業諮詢，為客戶量身打造專屬的iT服務",
        textImage = "drawable/progressive_app_m_9_ms.svg",
        padding = "4",
        keyID = 2
    ),
    titleData(
        title = "後端資料庫維護及資料分析",
        textContext = "Kotlin設計響應式網頁，Spring或Django建立後端，資料庫的維護以及分析",
        textImage = "drawable/server_cluster_jwwq.svg",
        padding = "4",
        keyID = 3
    ),
)


val forContextData = listOf(
    ContextData(
        title = "iOS 以及 android 原生語言進行堆疊式設計",
        textContext = listOf<String>("基於相同的堆疊邏輯，我們使用SwiftUI於iOS App, Koltlin Compose 於 andriod App。" ,
                "" ,
                "Swift 以及Koltin 皆是非常高效、安全的現代程式語言，我們可以讓兩個平台共享相同的堆疊邏輯，在加速開發流程的同時保證軟體的效率、易維護性。",
            ),
        textImage = "drawable/stack_design.jpg",
        backgroundImage = listOf<String>(),
        keyID = 1
    ),

    ContextData(
        title = "優秀的圖形介面設計，令人安心的專業諮詢",
        textContext = listOf<String>("我們利用Figma設計美觀實用的UI介面，透過設計師親自與客戶進行溝通，以及對產品的反覆試驗，能確保提供最優質的使用者體驗。" ,
                "" ,
                "承諾為產品提供一個月售後服務，包括軟體錯誤的修正、使用經驗的優化，我們執著於對產品的雕琢，以確保能夠向客戶保証：" ,
                "" ,
                "「您的滿意是我們最在乎的事情。」"),
        textImage = "drawable/Matlab.jpg",
        moreTextContext = listOf<String>(
            "我們利用Figma設計美觀實用的UI介面，以及對產品",
            "的反覆試驗，能確保提供最優質的使用者體驗。",
            "執著於對產品的雕琢，向客戶保証：",
            "「您的在乎是我們最在乎的事情。」"
        ),
        backgroundImage = listOf<String>("drawable/Blue_Top.png", "drawable/Blue_Bottom.png"),
        keyID = 2
    ),
    ContextData(
        title = "後端資料庫維護及資料分析",
        textContext = listOf<String>("我們使用Kotlin各種工具，包括Kotlin/js、Kotlin/Wasm來進行網頁的開發。",
                "",
                "透過String或Django設計伺服器以及資料庫，透過AWS或Google Cloud進行託管，並進行客戶要求的資料分析。"),
        textImage = "drawable/Koltin_Mark.jpg",
        moreTextContext = listOf<String>(
            "我們使用Kotlin各種工具，包括Kotlin/js、Kotlin/Wasm來進行網頁的開發。",
            "透過String或Django設計伺服器以及資料庫，透過AWS或Google Cloud進行託管，並進行客戶要求的資料分析。"
        ),
        backgroundImage = listOf<String>(),
        keyID = 3
    ),
    ContextData(
        title = "作品：旅遊排程App",
        textContext = listOf<String>("．花蓮知名景點介紹與照片" ,
                "．解鎖情境文學" ,
                "．多景點路徑最佳化"),
        textImage = "drawable/iphoneTitleView.jpg",
        moreTextContext = listOf<String>(
            "旅遊排程App",
            "立即體驗"
        ),
        backgroundImage = listOf<String>(
            "drawable/iphoneViewOne.png",
            "drawable/iphoneViewTwo.jpg",
            "drawable/QRcode.jpg",
            "drawable/appleMark.jpg",
            ),
        keyID = 4
    ),
)