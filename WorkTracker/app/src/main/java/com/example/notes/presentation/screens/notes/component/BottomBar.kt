package com.example.notes.presentation.screens.notes.component


import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.outlined.CheckBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun BottomBar(
    createNewNote: () -> Unit
) {
    BottomAppBar(
        actions = {
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(Icons.Outlined.CheckBox, contentDescription = "Localized description")
            }
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(
                    Icons.Filled.Edit,
                    contentDescription = "Localized description",
                )
            }
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(
                    Icons.Filled.Mic,
                    contentDescription = "Localized description",
                )
            }
            IconButton(onClick = { }) {
                Icon(
                    Icons.Filled.Image,
                    contentDescription = "Localized description",
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    createNewNote()
                },
                containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
            ) {
                Icon(Icons.Filled.Add, "Localized description")
            }
        }
    )
}


//@Composable
//fun PickImageFromGallery() {
//
//    var imageUri by remember { mutableStateOf<Uri?>(null) }
//    val context = LocalContext.current
//    val bitmap = remember { mutableStateOf<Bitmap?>(null) }
//
//    val launcher =
//        rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
//            imageUri = uri
//        }
//
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//
//        imageUri?.let {
//            if (Build.VERSION.SDK_INT < 28) {
//                bitmap.value = MediaStore.Images
//                    .Media.getBitmap(context.contentResolver, it)
//            } else {
//                val source = ImageDecoder.createSource(context.contentResolver, it)
//                bitmap.value = ImageDecoder.decodeBitmap(source)
//            }
//
//            bitmap.value?.let { btm ->
//                Image(
//                    bitmap = btm.asImageBitmap(),
//                    contentDescription = null,
//                    modifier = Modifier
//                        .size(400.dp)
//                        .padding(20.dp)
//                )
//            }
//        }
//
//        Spacer(modifier = Modifier.height(12.dp))
//
//        Button(onClick = { launcher.launch("image/*") }) {
//            Text(text = "Pick Image")
//        }
//    }
//}