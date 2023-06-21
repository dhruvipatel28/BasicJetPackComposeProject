package dhruvi.patel.sampleproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dhruvi.patel.sampleproject.ui.theme.HappyBirthDayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthDayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(
                        message = stringResource(R.string.happy_birthday_text),
                        fromName = stringResource(R.string.happy_birthday_wish_from_text)
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String, fromName: String, modifier: Modifier = Modifier){
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(20.dp)
    ) {
        Text(
            text = message,
            fontSize = 80.sp,
            lineHeight = 110.sp,
            textAlign = TextAlign.Center,

        )
        Text(
            text = "From: $fromName",
            fontSize = 25.sp,
            lineHeight = 28.sp,
            textAlign = TextAlign.End,
            modifier = modifier
                .padding(5.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun GreetingImage(message: String, fromName: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty)
    Box(
        modifier = modifier
    ) {
        Image(
            painter = image,
            contentDescription = "PartyImage",
            contentScale = ContentScale.Crop,
            alpha = 0.5f
        )
        GreetingText(
            message = "Happy Birthday Dear!",
            fromName = "Sample",
            modifier = modifier
                .fillMaxSize()
        )
    }

}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun BirthDayCardPreview() {
    HappyBirthDayTheme {
        GreetingImage(
            message = stringResource(R.string.happy_birthday_text),
            fromName = stringResource(R.string.happy_birthday_wish_from_text)
        )
    }
}

