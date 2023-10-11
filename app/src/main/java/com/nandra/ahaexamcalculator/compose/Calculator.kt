package com.nandra.ahaexamcalculator.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorView() {
    var result by remember {
        mutableStateOf("0")
    }

    fun addValue(value: String) {
        if (result.length == 1 && result == "0") {
            result = value
        } else {
            result += value
        }
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 18.dp, vertical = 16.dp)) {
            Text(text = result, style = TextStyle(fontSize = 80.sp), textAlign = TextAlign.End, modifier = Modifier.fillMaxWidth())
            Text(text = result, style = TextStyle(fontSize = 30.sp))
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            CalculatorButton(content = "AC", backgroundColor = Color(0xFFA1A1A1), onClick = {
                result = "0"
            })
            CalculatorButton(content = "+/-", backgroundColor = Color(0xFFA1A1A1), onClick = {

            })
            CalculatorButton(content = "%", backgroundColor = Color(0xFFA1A1A1), onClick = {
                addValue("%")
            })
            CalculatorButton(content = "/", backgroundColor = Color(0xFFF69D05), onClick = {
                addValue("/")
            })
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            CalculatorButton(content = "7", onClick = {
                addValue("7")
            })
            CalculatorButton(content = "8", onClick = {
                addValue("8")
            })
            CalculatorButton(content = "9", onClick = {
                addValue("9")
            })
            CalculatorButton(content = "X", backgroundColor = Color(0xFFF69D05), onClick = {
                addValue("X")
            })
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            CalculatorButton(content = "4", onClick = {
                addValue("4")
            })
            CalculatorButton(content = "5", onClick = {
                addValue("5")
            })
            CalculatorButton(content = "6", onClick = {
                addValue("6")
            })
            CalculatorButton(content = "-", backgroundColor = Color(0xFFF69D05), onClick = {
                addValue("-")
            })
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            CalculatorButton(content = "1", onClick = {
                addValue("1")
            })
            CalculatorButton(content = "2", onClick = {
                addValue("2")
            })
            CalculatorButton(content = "3", onClick = {
                addValue("3")
            })
            CalculatorButton(content = "+", backgroundColor = Color(0xFFF69D05), onClick = {
                addValue("+")
            })
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            CalculatorButton(content = "0", minWidth = 176.dp, onClick = {
                addValue("0")
            })
            CalculatorButton(content = ".", onClick = {
                addValue(".")
            })
            CalculatorButton(content = "=", backgroundColor = Color(0xFFF69D05), onClick = {

            })
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
private fun CalculatorButton(
    modifier: Modifier = Modifier,
    content: String,
    backgroundColor: Color? = null,
    textColor: Color? = null,
    minWidth: Dp = 80.dp,
    onClick: (() -> Unit)? = null
) {
    Surface(
        modifier = modifier
            .padding(horizontal = 8.dp)
            .clickable {
                onClick?.invoke()
            }
            .sizeIn(minWidth = minWidth), color = backgroundColor ?: Color(0xFF343434),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(
            text = content,
            modifier = Modifier.padding(8.dp),
            textAlign = TextAlign.Center,
            style = TextStyle(fontSize = 32.sp, color = Color(0xFFF8F8F8))
        )
    }
}

@Preview
@Composable
private fun PreviewCalculatorView() {
    Surface {
        CalculatorView()
    }
}