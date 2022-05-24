package com.example.myapplication0524


import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication0524.ui.theme.MyApplication0524Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplication0524Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }

        var db=MyDatabase.getInst(applicationContext)

        try{
            db.getDao().insertProd(Product("test",1))
            var plist=db.getDao().getAll()
            var mypro=""
            for(pd in plist){
                mypro+=pd.pname+"\n"
            }
            Toast.makeText(applicationContext,mypro,Toast.LENGTH_LONG).show()
        }catch(e:Exception){
            print(e.message)
        }

    }


}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplication0524Theme {
        Greeting("Android")
    }
}