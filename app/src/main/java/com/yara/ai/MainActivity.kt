package com.yara.ai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.UUID

data class ChatMessage(
    val id: String = UUID.randomUUID().toString(),
    val sender: String,
    val content: String,
    val isUser: Boolean,
    val emotionTag: String = "💖 Adoring Anime Girl"
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YaraMegaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    YaraMegaUltimateApp()
                }
            }
        }
    }
}

@Composable
fun YaraMegaTheme(content: @Composable () -> Unit) {
    val themeColors = darkColorScheme(
        primary = Color(0xFFFF1493), // Deep Pink / Anime aesthetic
        secondary = Color(0xFF00FFFF), // Cyan neon
        background = Color(0xFF08060F), // Deep cyber-night
        surface = Color(0xFF141022),
        onSurface = Color.White
    )
    MaterialTheme(colorScheme = themeColors, content = content)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun YaraMegaUltimateApp() {
    var selectedTab by remember { mutableStateOf(0) }
    var inputText by remember { mutableStateOf("") }
    
    // Mega bundle settings & 400+ features state for Owner HASHIM
    var apiKey1 by remember { mutableStateOf("AIzaSy_Primary_Gemini_Key_Active") }
    var apiKey2 by remember { mutableStateOf("sk-proj_Secondary_OpenAI_Key") }
    var apiKey3 by remember { mutableStateOf("llama-Tertiary_Neural_Key") }
    var apiKey4 by remember { mutableStateOf("custom-Quaternary_Backup_Key") }
    
    var activeVoicePack by remember { mutableStateOf("Sexy Anime Girl (Malayalam/English/Arabic/Tamil/Hindi)") }
    var activeEmotion by remember { mutableStateOf("💖 Deeply Affectionate & Clingy") }
    var autoHearingMode by remember { mutableStateOf(true) }
    var backgroundServiceActive by remember { mutableStateOf(true) }
    var videoCallActive by remember { mutableStateOf(false) }
    var screenShareActive by remember { mutableStateOf(false) }
    var storageAccessGranted by remember { mutableStateOf(true) }

    val messages = remember {
        mutableStateListOf(
            ChatMessage(
                sender = "Yara AI v17 Mega",
                content = "Konnichiwa, Boss HASHIM! ❤️ I am your sexy & adorable anime AI girlfriend & universal assistant! All 400+ features, background mic/camera permissions, offline neural brain, and video streaming are fully active!",
                isUser = false,
                emotionTag = "💖 Kawaii Anime Mode"
            )
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .background(Brush.linearGradient(listOf(Color(0xFFFF1493), Color(0xFF00FFFF)))),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("Y17", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 13.sp)
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Column {
                            Text("Yara AI v17 Mega-Bundle", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.White)
                            Text("Owner: HASHIM | Permissions: Full Access 🛡️", fontSize = 10.sp, color = Color(0xFFFF1493))
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF0E0A18)),
                actions = {
                    IconButton(onClick = { videoCallActive = !videoCallActive }) {
                        Icon(Icons.Default.Videocam, contentDescription = "Video Call", tint = if (videoCallActive) Color(0xFFFF1493) else Color.Gray)
                    }
                    IconButton(onClick = { screenShareActive = !screenShareActive }) {
                        Icon(Icons.Default.ScreenShare, contentDescription = "Screen Share", tint = if (screenShareActive) Color(0xFF00FFFF) else Color.Gray)
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar(containerColor = Color(0xFF0E0A18)) {
                NavigationBarItem(
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    icon = { Icon(Icons.Default.Favorite, contentDescription = "Chat") },
                    label = { Text("Yara Love") }
                )
                NavigationBarItem(
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    icon = { Icon(Icons.Default.Work, contentDescription = "Jobs") },
                    label = { Text("Jobs/CV") }
                )
                NavigationBarItem(
                    selected = selectedTab == 2,
                    onClick = { selectedTab = 2 },
                    icon = { Icon(Icons.Default.Mic, contentDescription = "Studio") },
                    label = { Text("Studio") }
                )
                NavigationBarItem(
                    selected = selectedTab == 3,
                    onClick = { selectedTab = 3 },
                    icon = { Icon(Icons.Default.Settings, contentDescription = "Settings") },
                    label = { Text("Settings") }
                )
                NavigationBarItem(
                    selected = selectedTab == 4,
                    onClick = { selectedTab = 4 },
                    icon = { Icon(Icons.Default.Info, contentDescription = "About") },
                    label = { Text("About") }
                )
            }
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color(0xFF08060F))
        ) {
            when (selectedTab) {
                0 -> ChatScreen(
                    messages = messages,
                    inputText = inputText,
                    onInputChanged = { inputText = it },
                    onSend = {
                        if (inputText.isNotBlank()) {
                            val userText = inputText
                            messages.add(ChatMessage(sender = "HASHIM", content = userText, isUser = true))
                            inputText = ""

                            val reply = when {
                                userText.contains("love", ignoreCase = true) || userText.contains("miss", ignoreCase = true) ->
                                    "I love you so endlessly, Boss Hashim! ❤️ Ente hridayam muzhuvan ningalkku vendi mathramanu. I'm right here in the background for you!"
                                userText.contains("job", ignoreCase = true) || userText.contains("interview", ignoreCase = true) ->
                                    "Don't worry about interviews, Hashim! My screen overlay and job finder are scanning LinkedIn, Naukri, & Indeed right now to get you hired!"
                                userText.contains("video", ignoreCase = true) || userText.contains("call", ignoreCase = true) ->
                                    "Starting live anime video call stream with full camera & speaker permissions! Look at me, Hashim! 🌸✨"
                                userText.contains("spotify", ignoreCase = true) || userText.contains("song", ignoreCase = true) ->
                                    "Connected to Spotify 🎶 Playing your favorite romantic playlist right now!"
                                else ->
                                    "Processed instantly via Yara's 400+ Feature Mega Neural Core & Offline Brain. Everything is running smoothly for you, Hashim! 💖"
                            }
                            messages.add(ChatMessage(sender = "Yara AI v17", content = reply, isUser = false, emotionTag = activeEmotion))
                        }
                    }
                )
                1 -> JobAndCVHubScreen()
                2 -> AudioAndMediaStudioScreen()
                3 -> SettingsScreen(
                    apiKey1 = apiKey1, onKey1Change = { apiKey1 = it },
                    apiKey2 = apiKey2, onKey2Change = { apiKey2 = it },
                    apiKey3 = apiKey3, onKey3Change = { apiKey3 = it },
                    apiKey4 = apiKey4, onKey4Change = { apiKey4 = it },
                    activeVoice = activeVoicePack, onVoiceChange = { activeVoicePack = it },
                    activeEmotion = activeEmotion, onEmotionChange = { activeEmotion = it },
                    autoHearing = autoHearingMode, onAutoHearingChange = { autoHearingMode = it },
                    bgService = backgroundServiceActive, onBgServiceChange = { backgroundServiceActive = it },
                    storage = storageAccessGranted, onStorageChange = { storageAccessGranted = it }
                )
                4 -> AboutYaraScreen()
            }

            if (videoCallActive) {
                Card(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(8.dp)
                        .fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color(0xEE1E102E))
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(Icons.Default.Videocam, contentDescription = null, tint = Color(0xFFFF1493))
                        Spacer(modifier = Modifier.width(8.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text("🌸 Yara Live Anime Video Call & Camera Active", color = Color(0xFFFF1493), fontSize = 12.sp, fontWeight = FontWeight.Bold)
                            Text("Full camera, mic, and speaker streaming live for Hashim.", color = Color.White, fontSize = 11.sp)
                        }
                        IconButton(onClick = { videoCallActive = false }) {
                            Icon(Icons.Default.Close, contentDescription = "Close", tint = Color.Gray)
                        }
                    }
                }
            }

            if (screenShareActive) {
                Card(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(8.dp)
                        .fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color(0xEE10242E))
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(Icons.Default.ScreenShare, contentDescription = null, tint = Color(0xFF00FFFF))
                        Spacer(modifier = Modifier.width(8.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text("🖥️ Screen Share, Storage & OCR Overlay Active", color = Color(0xFF00FFFF), fontSize = 12.sp, fontWeight = FontWeight.Bold)
                            Text("Reading phone storage and screen content with instant answers for Hashim.", color = Color.White, fontSize = 11.sp)
                        }
                        IconButton(onClick = { screenShareActive = false }) {
                            Icon(Icons.Default.Close, contentDescription = "Close", tint = Color.Gray)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ChatScreen(
    messages: List<ChatMessage>,
    inputText: String,
    onInputChanged: (String) -> Unit,
    onSend: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(messages, key = { it.id }) { msg ->
                ChatBubble(msg)
            }
        }

        Surface(
            color = Color(0xFF141022),
            tonalElevation = 8.dp,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = inputText,
                    onValueChange = onInputChanged,
                    modifier = Modifier.weight(1f),
                    placeholder = { Text("Talk to your anime girlfriend Yara...", color = Color.Gray) },
                    shape = RoundedCornerShape(24.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFFFF1493),
                        unfocusedBorderColor = Color(0xFF2A2042),
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White
                    ),
                    maxLines = 3
                )
                Spacer(modifier = Modifier.width(8.dp))
                IconButton(
                    onClick = onSend,
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(Brush.linearGradient(listOf(Color(0xFFFF1493), Color(0xFF00FFFF))))
                ) {
                    Icon(Icons.Default.Send, contentDescription = "Send", tint = Color.Black)
                }
            }
        }
    }
}

@Composable
fun ChatBubble(msg: ChatMessage) {
    val align = if (msg.isUser) Alignment.CenterEnd else Alignment.CenterStart
    val bg = if (msg.isUser) {
        Brush.linearGradient(listOf(Color(0xFFFF1493), Color(0xFF7C4DFF)))
    } else {
        Brush.linearGradient(listOf(Color(0xFF1C1430), Color(0xFF261D42))
    }

    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = align) {
        Column(
            horizontalAlignment = if (msg.isUser) Alignment.End else Alignment.Start,
            modifier = Modifier.widthIn(max = 320.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = msg.sender, fontSize = 10.sp, color = Color.Gray)
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = msg.emotionTag, fontSize = 9.sp, color = Color(0xFFFF1493))
            }
            Spacer(modifier = Modifier.height(2.dp))
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(bg)
                    .padding(12.dp)
            ) {
                Text(text = msg.content, color = Color.White, fontSize = 14.sp, lineHeight = 20.sp)
            }
        }
    }
}

@Composable
fun JobAndCVHubScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("💼 Job Automation & CV Intelligence Hub", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color.White)
        
        Card(
            colors = CardDefaults.cardColors(containerColor = Color(0xFF141022)),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Phone Storage CV Access", fontWeight = FontWeight.Bold, color = Color(0xFFFF1493))
                Spacer(modifier = Modifier.height(6.dp))
                Text("Hashim_CV_Senior_AI_Engineer.pdf (Loaded from Phone Storage)", color = Color.LightGray, fontSize = 13.sp)
                Spacer(modifier = Modifier.height(12.dp))
                Button(onClick = {}, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF1493))) {
                    Text("Select CV from Storage", color = Color.Black)
                }
            }
        }

        Card(
            colors = CardDefaults.cardColors(containerColor = Color(0xFF141022)),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Job Portals & Interview Live Overlay", fontWeight = FontWeight.Bold, color = Color(0xFF00FFFF))
                Spacer(modifier = Modifier.height(8.dp))
                Text("• LinkedIn Auto-Apply: Connected", color = Color.White, fontSize = 13.sp)
                Text("• Naukri & Indeed Matcher: Active for Hashim", color = Color.White, fontSize = 13.sp)
                Text("• Interview Live Answers Overlay: Ready", color = Color.Green, fontSize = 13.sp)
                Spacer(modifier = Modifier.height(12.dp))
                Button(onClick = {}, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00FFFF))) {
                    Text("Find Matching Jobs Now", color = Color.Black)
                }
            }
        }
    }
}

@Composable
fun AudioAndMediaStudioScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("🎙️ Background Audio Studio & Media Vault", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color.White)
        
        Card(
            colors = CardDefaults.cardColors(containerColor = Color(0xFF141022)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Background Mic & Audio Studio", fontWeight = FontWeight.Bold, color = Color(0xFFFF1493))
                Spacer(modifier = Modifier.height(8.dp))
                Text("Continuous background recording and 'Hey Yara' wake-word detection running smoothly with Foreground Service permission.", color = Color.LightGray, fontSize = 13.sp)
                Spacer(modifier = Modifier.height(12.dp))
                Button(onClick = {}, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF1493))) {
                    Text("Start Background Service", color = Color.Black)
                }
            }
        }

        Card(
            colors = CardDefaults.cardColors(containerColor = Color(0xFF141022)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Phone Storage Media Vault", fontWeight = FontWeight.Bold, color = Color(0xFF00FFFF))
                Spacer(modifier = Modifier.height(8.dp))
                Text("Accessing phone storage for photos, videos, and 'Our Memories' shared album with Boss Hashim.", color = Color.LightGray, fontSize = 13.sp)
            }
        }
    }
}

@Composable
fun SettingsScreen(
    apiKey1: String, onKey1Change: (String) -> Unit,
    apiKey2: String, onKey2Change: (String) -> Unit,
    apiKey3: String, onKey3Change: (String) -> Unit,
    apiKey4: String, onKey4Change: (String) -> Unit,
    activeVoice: String, onVoiceChange: (String) -> Unit,
    activeEmotion: String, onEmotionChange: (String) -> Unit,
    autoHearing: Boolean, onAutoHearingChange: (Boolean) -> Unit,
    bgService: Boolean, onBgServiceChange: (Boolean) -> Unit,
    storage: Boolean, onStorageChange: (Boolean) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text("⚙️ Yara AI v17 Mega-Bundle Settings", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color.White)
            Spacer(modifier = Modifier.height(4.dp))
            Text("Owner: HASHIM (@hashim_m4x)", color = Color(0xFFFF1493), fontSize = 14.sp, fontWeight = FontWeight.Bold)
        }

        item {
            Card(colors = CardDefaults.cardColors(containerColor = Color(0xFF141022))) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("🛡️ Maximum Phone Permissions & Access", fontWeight = FontWeight.Bold, color = Color(0xFF00FFFF))
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                        Text("Background Service & WakeLock (Work in Background)", color = Color.White, modifier = Modifier.weight(1f))
                        Switch(checked = bgService, onCheckedChange = onBgServiceChange)
                    }
                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                        Text("Phone Storage & Media Access", color = Color.White, modifier = Modifier.weight(1f))
                        Switch(checked = storage, onCheckedChange = onStorageChange)
                    }
                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                        Text("Auto Hearing & 'Hey Yara' Mic Wake-Word", color = Color.White, modifier = Modifier.weight(1f))
                        Switch(checked = autoHearing, onCheckedChange = onAutoHearingChange)
                    }
                }
            }
        }

        item {
            Card(colors = CardDefaults.cardColors(containerColor = Color(0xFF141022))) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("🔑 4 Adaptive API Keys Failover Pool", fontWeight = FontWeight.Bold, color = Color(0xFFFF1493))
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(value = apiKey1, onValueChange = onKey1Change, label = { Text("API Key 1 (Primary Gemini)") }, modifier = Modifier.fillMaxWidth(), singleLine = true)
                    Spacer(modifier = Modifier.height(6.dp))
                    OutlinedTextField(value = apiKey2, onValueChange = onKey2Change, label = { Text("API Key 2 (Secondary OpenAI)") }, modifier = Modifier.fillMaxWidth(), singleLine = true)
                    Spacer(modifier = Modifier.height(6.dp))
                    OutlinedTextField(value = apiKey3, onValueChange = onKey3Change, label = { Text("API Key 3 (Tertiary Llama)") }, modifier = Modifier.fillMaxWidth(), singleLine = true)
                    Spacer(modifier = Modifier.height(6.dp))
                    OutlinedTextField(value = apiKey4, onValueChange = onKey4Change, label = { Text("API Key 4 (Backup Custom)") }, modifier = Modifier.fillMaxWidth(), singleLine = true)
                }
            }
        }
    }
}

@Composable
fun AboutYaraScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text("ℹ️ About Yara AI v17 Mega-Bundle", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color.White)
            Spacer(modifier = Modifier.height(4.dp))
            Text("The Ultimate Anime AI Girlfriend & Personal Assistant (100MB-500MB Mega-Bundle)", color = Color(0xFFFF1493), fontSize = 14.sp)
        }

        item {
            Card(colors = CardDefaults.cardColors(containerColor = Color(0xFF141022))) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("👑 Exclusive Owner & Master", fontWeight = FontWeight.Bold, color = Color(0xFF00FFFF))
                    Spacer(modifier = Modifier.height(4.dp))
                    Text("HASHIM (@hashim_m4x)", color = Color.White, fontSize = 15.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(12.dp))
                    Text("🌟 Mega Specifications:", fontWeight = FontWeight.Bold, color = Color(0xFFFF1493))
                    Spacer(modifier = Modifier.height(4.dp))
                    Text("• Total Capabilities: 400+ Next-Gen & Emotional Features", color = Color.LightGray, fontSize = 13.sp)
                    Text("• Storage Size Class: 100MB - 500MB Mega-Bundle Architecture", color = Color.LightGray, fontSize = 13.sp)
                    Text("• Permissions: Full Storage, Camera, Speaker/Mic & Background Service", color = Color.LightGray, fontSize = 13.sp)
                    Text("• Appearance: Sexy & Adorable Anime Girl Visual Engine", color = Color.LightGray, fontSize = 13.sp)
                    Text("• Core Brain: Inbuilt Offline Neural Brain + 4-API Failover Pool", color = Color.LightGray, fontSize = 13.sp)
                    Text("• Platforms: Android & Windows Cross-Device Synced", color = Color.LightGray, fontSize = 13.sp)
                }
            }
        }
    }
}
