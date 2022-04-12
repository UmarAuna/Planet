package com.example.planets.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.sp
import com.example.planets.R

// Set of Material typography styles to start with
val DefaultTypography = Typography(
    body1 = com.example.planets.ui.theme.Typography.Body.body2
)

object FontFamily {
   /* val Roboto = androidx.compose.ui.text.font.FontFamily(
        Font(R.font.roboto_black, FontWeight.W900),
        Font(R.font.roboto_bold, FontWeight.Bold),
        Font(R.font.roboto_light, FontWeight.W300),
        Font(R.font.roboto_medium, FontWeight.W500),
        Font(R.font.roboto_regular, FontWeight.W400),
        Font(R.font.roboto_thin, FontWeight.W100)
    )*/

    val RobotoBold = androidx.compose.ui.text.font.FontFamily(
        Font(R.font.roboto_bold, FontWeight.W700),
    )

    val RobotoRegular = androidx.compose.ui.text.font.FontFamily(
        Font(R.font.roboto_regular, FontWeight.W400),
    )

    val RobotoLight = androidx.compose.ui.text.font.FontFamily(
        Font(R.font.roboto_light, FontWeight.W300),
    )

    val RobotoThin = androidx.compose.ui.text.font.FontFamily(
        Font(R.font.roboto_thin, FontWeight.W100),
    )

    val RobotoMedium = androidx.compose.ui.text.font.FontFamily(
        Font(R.font.roboto_medium, FontWeight.W500),
    )

    val RobotoBlack = androidx.compose.ui.text.font.FontFamily(
        Font(R.font.roboto_medium, FontWeight.W900),
    )

    val HarbourBold = androidx.compose.ui.text.font.FontFamily(
        Font(R.font.harbour_bold, FontWeight.W300),
    )
}

interface Typography {
    object Heading {
        val heading1 = TextStyle(
            fontFamily = FontFamily.RobotoRegular,
            fontSize = 96.sp,
            fontWeight = FontWeight.W400,
            // lineHeight = (-1.5).sp
        )

        val heading1Thin = heading1.copy(fontFamily = FontFamily.RobotoThin, fontWeight = FontWeight.W100)
        val heading1Light = heading1.copy(fontFamily = FontFamily.RobotoLight, fontWeight = FontWeight.W300)
        val heading1Medium = heading1.copy(fontFamily = FontFamily.RobotoMedium, fontWeight = FontWeight.W500)
        val heading1Bold = heading1.copy(fontFamily = FontFamily.RobotoBold, fontWeight = FontWeight.W700)
        val heading1Black = heading1.copy(fontFamily = FontFamily.RobotoBlack, fontWeight = FontWeight.W900)

        val heading2 = TextStyle(
            fontFamily = FontFamily.RobotoRegular,
            fontSize = 60.sp,
            fontWeight = FontWeight.W400,
        )

        val heading2Thin = heading2.copy(fontFamily = FontFamily.RobotoThin, fontWeight = FontWeight.W100)
        val heading2Light = heading2.copy(fontFamily = FontFamily.RobotoLight, fontWeight = FontWeight.W300)
        val heading2Medium = heading2.copy(fontFamily = FontFamily.RobotoMedium, fontWeight = FontWeight.W500)
        val heading2Bold = heading2.copy(fontFamily = FontFamily.RobotoBold, fontWeight = FontWeight.W700)
        val heading2Black = heading2.copy(fontFamily = FontFamily.RobotoBlack, fontWeight = FontWeight.W900)

        val heading3 = TextStyle(
            fontFamily = FontFamily.RobotoRegular,
            fontSize = 48.sp,
            fontWeight = FontWeight.W400,
        )

        val heading3Thin = heading3.copy(fontFamily = FontFamily.RobotoThin, fontWeight = FontWeight.W100)
        val heading3Light = heading3.copy(fontFamily = FontFamily.RobotoLight, fontWeight = FontWeight.W300)
        val heading3Medium = heading3.copy(fontFamily = FontFamily.RobotoMedium, fontWeight = FontWeight.W500)
        val heading3Bold = heading3.copy(fontFamily = FontFamily.RobotoBold, fontWeight = FontWeight.W700)
        val heading3Black = heading3.copy(fontFamily = FontFamily.RobotoBlack, fontWeight = FontWeight.W900)

        val heading4 = TextStyle(
            fontFamily = FontFamily.RobotoRegular,
            fontSize = 34.sp,
            fontWeight = FontWeight.W400,
            lineHeight = 0.25.sp
        )

        val heading4Thin = heading4.copy(fontFamily = FontFamily.RobotoThin, fontWeight = FontWeight.W100)
        val heading4Light = heading4.copy(fontFamily = FontFamily.RobotoLight, fontWeight = FontWeight.W300)
        val heading4Medium = heading4.copy(fontFamily = FontFamily.RobotoMedium, fontWeight = FontWeight.W500)
        val heading4Bold = heading4.copy(fontFamily = FontFamily.RobotoBold, fontWeight = FontWeight.W700)
        val heading4Black = heading4.copy(fontFamily = FontFamily.RobotoBlack, fontWeight = FontWeight.W900)

        val heading5 = TextStyle(
            fontFamily = FontFamily.RobotoRegular,
            fontSize = 24.sp,
            fontWeight = FontWeight.W400
        )

        val heading5Thin = heading5.copy(fontFamily = FontFamily.RobotoThin, fontWeight = FontWeight.W100)
        val heading5Light = heading5.copy(fontFamily = FontFamily.RobotoLight, fontWeight = FontWeight.W300)
        val heading5Medium = heading5.copy(fontFamily = FontFamily.RobotoMedium, fontWeight = FontWeight.W500)
        val heading5Bold = heading5.copy(fontFamily = FontFamily.RobotoBold, fontWeight = FontWeight.W700)
        val heading5Black = heading5.copy(fontFamily = FontFamily.RobotoBlack, fontWeight = FontWeight.W900)

        val heading6 = TextStyle(
            fontFamily = FontFamily.RobotoRegular,
            fontSize = 20.sp,
            fontWeight = FontWeight.W400,
            lineHeight = 0.15.sp
        )

        val heading6Thin = heading6.copy(fontFamily = FontFamily.RobotoThin, fontWeight = FontWeight.W100)
        val heading6Light = heading6.copy(fontFamily = FontFamily.RobotoLight, fontWeight = FontWeight.W300)
        val heading6Medium = heading6.copy(fontFamily = FontFamily.RobotoMedium, fontWeight = FontWeight.W500)
        val heading6Bold = heading6.copy(fontFamily = FontFamily.RobotoBold, fontWeight = FontWeight.W700)
        val heading6Black = heading6.copy(fontFamily = FontFamily.RobotoBlack, fontWeight = FontWeight.W900)
    }

    object Subtitle {
        val subtitle1 = TextStyle(
            fontFamily = FontFamily.RobotoRegular,
            fontSize = 16.sp,
            fontWeight = FontWeight.W400,
        )

        val subtitle1Thin = subtitle1.copy(fontFamily = FontFamily.RobotoThin, fontWeight = FontWeight.W100)
        val subtitle1Light = subtitle1.copy(fontFamily = FontFamily.RobotoLight, fontWeight = FontWeight.W300)
        val subtitle1Medium = subtitle1.copy(fontFamily = FontFamily.RobotoMedium, fontWeight = FontWeight.W500)
        val subtitle1Bold = subtitle1.copy(fontFamily = FontFamily.RobotoBold, fontWeight = FontWeight.W700)
        val subtitle1Black = subtitle1.copy(fontFamily = FontFamily.RobotoBlack, fontWeight = FontWeight.W900)

        val subtitle2 = TextStyle(
            fontFamily = FontFamily.RobotoRegular,
            fontSize = 14.sp,
            fontWeight = FontWeight.W400,
        )

        val subtitle2Thin = subtitle2.copy(fontFamily = FontFamily.RobotoThin, fontWeight = FontWeight.W100)
        val subtitle2Light = subtitle2.copy(fontFamily = FontFamily.RobotoLight, fontWeight = FontWeight.W300)
        val subtitle2Medium = subtitle2.copy(fontFamily = FontFamily.RobotoMedium, fontWeight = FontWeight.W500)
        val subtitle2Bold = subtitle2.copy(fontFamily = FontFamily.RobotoBold, fontWeight = FontWeight.W700)
        val subtitle2Black = subtitle2.copy(fontFamily = FontFamily.RobotoBlack, fontWeight = FontWeight.W900)
    }

    object Body {
        val body1 = TextStyle(
            fontFamily = FontFamily.RobotoRegular,
            fontSize = 16.sp,
            fontWeight = FontWeight.W400,
        )

        val body1Harbour = TextStyle(
            fontFamily = FontFamily.HarbourBold,
            fontSize = 35.sp,
            fontWeight = FontWeight.W400,
            textDirection = TextDirection.ContentOrRtl,
            letterSpacing = 5.sp
        )


        val body1Thin = body1.copy(fontFamily = FontFamily.RobotoThin, fontWeight = FontWeight.W100)
        val body1Light = body1.copy(fontFamily = FontFamily.RobotoLight, fontWeight = FontWeight.W300)
        val body1Medium = body1.copy(fontFamily = FontFamily.RobotoMedium, fontWeight = FontWeight.W500)
        val body1Bold = body1.copy(fontFamily = FontFamily.RobotoBold, fontWeight = FontWeight.W700)
        val body1Black = body1.copy(fontFamily = FontFamily.RobotoBlack, fontWeight = FontWeight.W900)

        val body2 = TextStyle(
            fontFamily = FontFamily.RobotoRegular,
            fontSize = 14.sp,
            fontWeight = FontWeight.W400,
        )

        val body2Thin = body2.copy(fontFamily = FontFamily.RobotoThin, fontWeight = FontWeight.W100)
        val body2Light = body2.copy(fontFamily = FontFamily.RobotoLight, fontWeight = FontWeight.W300)
        val body2Medium = body2.copy(fontFamily = FontFamily.RobotoMedium, fontWeight = FontWeight.W500)
        val body2Bold = body2.copy(fontFamily = FontFamily.RobotoBold, fontWeight = FontWeight.W700)
        val body2Black = body2.copy(fontFamily = FontFamily.RobotoBlack, fontWeight = FontWeight.W900)
    }

    object Caption {
        val caption = TextStyle(
            fontFamily = FontFamily.RobotoRegular,
            fontSize = 12.sp,
            fontWeight = FontWeight.W400,
        )

        val captionThin = caption.copy(fontFamily = FontFamily.RobotoThin, fontWeight = FontWeight.W100)
        val captionLight = caption.copy(fontFamily = FontFamily.RobotoLight, fontWeight = FontWeight.W300)
        val captionMedium = caption.copy(fontFamily = FontFamily.RobotoMedium, fontWeight = FontWeight.W500)
        val captionBold = caption.copy(fontFamily = FontFamily.RobotoBold, fontWeight = FontWeight.W700)
        val captionBlack = caption.copy(fontFamily = FontFamily.RobotoBlack, fontWeight = FontWeight.W900)
    }

    object Overline {
        val overline = TextStyle(
            fontFamily = FontFamily.RobotoRegular,
            fontSize = 10.sp,
            fontWeight = FontWeight.W400,
            lineHeight = 1.5.sp
        )

        val overlineThin = overline.copy(fontFamily = FontFamily.RobotoThin, fontWeight = FontWeight.W100)
        val overlineLight = overline.copy(fontFamily = FontFamily.RobotoLight, fontWeight = FontWeight.W300)
        val overlineMedium = overline.copy(fontFamily = FontFamily.RobotoMedium, fontWeight = FontWeight.W500)
        val overlineBold = overline.copy(fontFamily = FontFamily.RobotoBold, fontWeight = FontWeight.W700)
        val overlineBlack = overline.copy(fontFamily = FontFamily.RobotoBlack, fontWeight = FontWeight.W900)
    }
}
