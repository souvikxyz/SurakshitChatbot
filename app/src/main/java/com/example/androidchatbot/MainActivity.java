package com.example.androidchatbot;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.androidchatbot.Adapter.ChatMessageAdapter;
import com.example.androidchatbot.Model.ChatMessage;

import org.alicebot.ab.AIMLProcessor;
import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import org.alicebot.ab.MagicStrings;
import org.alicebot.ab.PCAIMLProcessorExtension;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    FloatingActionButton btnSend;
    EditText edtTextMsg;
    ImageView imageView;

    private Bot bot;
    public static Chat chat;
    private ChatMessageAdapter adapter;

    String JSON_STRING = "{\"questions\":{\"QUESTION\":[\">200\",\">400\",\">600\",\">800\"]}}";

    Button setOptions1, setOptions2, setOptions3, setOptions4;
    int clickcount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        btnSend = findViewById(R.id.btnSend);
        edtTextMsg = findViewById(R.id.edtTextMsg);
        imageView = findViewById(R.id.imageView);
        setOptions1 = findViewById(R.id.button1);
        setOptions2 = findViewById(R.id.button2);
        setOptions3 = findViewById(R.id.button3);
        setOptions4 = findViewById(R.id.button4);
//        Button[] setOptions = new Button[4];
//        for(int i=0;i<4;i++){
//            setOptions[i]=
//        }
        adapter = new ChatMessageAdapter(this, new ArrayList<ChatMessage>());
        listView.setAdapter(adapter);


        //try {
//            // get JSONObject from JSON file
//            JSONObject obj = new JSONObject(JSON_STRING);
//            // fetch JSONObject named employee
//            JSONObject questions = obj.getJSONObject("questions");
//            // get employee name and salary
////            question = questions.getString(1);
//            JSONArray options = questions.getJSONArray("QUESTION");
//            final String option1 = options.getString(1);
//
//            convertView= LayoutInflater.from(getContext())

//            setOptions2.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    clickcount=clickcount+1;
//                    if(clickcount%2==0)
//                    {
//                        setOptions1.setVisibility(View.VISIBLE);
//                    }
//                    else {
//                          setOptions1.setVisibility(View.INVISIBLE);
////                        ViewGroup group = (ViewGroup)(setOptions1.getParent()); group.removeView(setOptions1);
//                    }
//
//                }
//            });
        ////////////////////////////////////////////////////////////
//            setContentView(R.layout.activity_main);
////////////////////////////////////////////////////////////////////
//
        //      while(int i<=5){
//         botsReply("HOW MANY DEAD");
//
//       String questions[]=getJsonFileFromLocally();
//       int len=questions.length;
//       for(int i=0;i<len;i++){
//            if(i==1){
//                botsReply(questions[i]);
//
//            }}
//           LinearLayout lay_1 = findViewById(R.id.quick_reply);
//            setOptions1.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
////                    LinearLayout lay_1 = findViewById(R.id.quick_reply);
//                    String message = setOptions1.getText().toString();
//                    String response = chat.multisentenceRespond(message);
//                    sendMessage(message);
//                    botsReply(response);
////                    lay_1.setVisibility(View.INVISIBLE);
//
//
//                }
//
//            });
//            setOptions2.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
////                    LinearLayout lay_1 = findViewById(R.id.quick_reply);
//                    String message = setOptions2.getText().toString();
//                    String response = chat.multisentenceRespond(message);
//                    sendMessage(message);
//                    botsReply(response);
////                    lay_1.setVisibility(View.INVISIBLE);
//
//
//                }
//
//            });
//            setOptions3.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
////                    LinearLayout lay_1 = findViewById(R.id.quick_reply);
//                    String message = setOptions3.getText().toString();
//                    String response = chat.multisentenceRespond(message);
//                    sendMessage(message);
//                    botsReply(response);
////                    lay_1.setVisibility(View.INVISIBLE);
//
//                }
//
//            });
//            setOptions4.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
////                    LinearLayout lay_1 = findViewById(R.id.quick_reply);
//                    String message = setOptions4.getText().toString();
//                    String response = chat.multisentenceRespond(message);
//                    sendMessage(message);
//                    botsReply(response);
////                    lay_1.setVisibility(View.INVISIBLE);
//
//
//                }
//
//            });


//            if(i==5)
//                lay_1.setVisibility(View.INVISIBLE);

//        }
//        if ( false )
//        {
//            setOptions.setVisibility(View.VISIBLE); //SHOW the button
//        }
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }


//        btnSend.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//        String message= "abcd";
//        String response = chat.multisentenceRespond("abcd");
//                Context context;
//                LayoutInflater inflater = (LayoutInflater) context
//                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//                View view = inflater.inflate(R.layout.quick_reply_layout, parent, false);
//                String message=edtTextMsg.getText().toString();
//
//                String response = chat.multisentenceRespond(edtTextMsg.getText().toString());
//
//                if(TextUtils.isEmpty(message)) {
//                    Toast.makeText(MainActivity.this, "Please Enter a query", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                sendMessage(message);
//                botsReply(response);
//
//                clear edittext
//                edtTextMsg.setText("");
//                listView.setSelection(adapter.getCount() - 1);
//            }
//        });

        boolean available = isSDCardAvailable();
        AssetManager assets = getResources().getAssets();

        File fileName = new File(Environment.getExternalStorageDirectory().toString() + "/TBC/bots/TBC");
        boolean makeFile = fileName.mkdirs();

        if (fileName.exists()) {
//            read the line

            try {
                for (String dir : assets.list("TBC")) {
                    File subDir = new File(fileName.getPath() + "/" + dir);
                    boolean subDir_Check = subDir.mkdirs();

                    for (String file : assets.list("TBC/" + dir)) {
                        File newFile = new File(fileName.getPath() + "/" + dir + "/" + file);

                        if (newFile.exists()) {
                            continue;
                        }
                        InputStream in;
                        OutputStream out;
                        in = assets.open("TBC/" + dir + "/" + file);
                        out = new FileOutputStream(fileName.getPath() + "/" + dir + "/" + file);

                        //copy files from assets to the mobile's sd card or any secondary memory available

                        copyFile(in, out);
                        in.close();
                        out.flush();
                        out.close();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //get the working directory
        MagicStrings.root_path = Environment.getExternalStorageDirectory().toString() + "/TBC";
        AIMLProcessor.extension = new PCAIMLProcessorExtension();

        bot = new Bot("TBC", MagicStrings.root_path, "chat");
        chat = new Chat(bot);

        loadJSon();

    }

    public void loadJSon() {

        Resources res = getResources();
        InputStream is = res.openRawResource(R.raw.questions);
        Scanner scanner = new Scanner(is);

        StringBuilder builder = new StringBuilder();


        while (scanner.hasNextLine()) {
            builder.append(scanner.nextLine());
        }
        parseJson(builder.toString());
    }

    private void parseJson(String s) {
        StringBuilder builder = new StringBuilder();
        try {
            JSONObject root = new JSONObject(s);
            String fir = root.getString("fir");
            botsReply(fir);
            JSONArray question_dict = root.getJSONArray("question_dict");

            for (int i = 0; i < question_dict.length(); ) {
                JSONObject ques = question_dict.getJSONObject(i);
                String que = ques.getString("que");
                botsReply(que);
                String options = ques.getString("options");
                LinearLayout lay_2 = findViewById(R.id.quick_reply);
                LinearLayout sndmessage = findViewById(R.id.send_message_layout);
                    if(options=="0") {

                            sndmessage.setVisibility(View.VISIBLE);
                            btnSend.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                    String message = edtTextMsg.getText().toString();

                                    String response = chat.multisentenceRespond(edtTextMsg.getText().toString());

                                    if (TextUtils.isEmpty(message)) {
                                        Toast.makeText(MainActivity.this, "Please Enter a query", Toast.LENGTH_SHORT).show();
                                        return;
                                    }
                                    sendMessage(message);
                                    botsReply("OK");

                                    edtTextMsg.setText("");
                                    listView.setSelection(adapter.getCount() - 1);
                                }
                            });
                        }
                        else if(options=="2") {
                            setOptions2.setVisibility(View.VISIBLE);
                            setOptions1.setVisibility(View.VISIBLE);
                            setOptions1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
//
                                    setOptions1.setText("Yes");
                                    String message = setOptions1.getText().toString();
                                    sendMessage(message);
                                    botsReply("OK");

                                }

                            });

                            setOptions2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
//                    LinearLayout lay_1 = findViewById(R.id.quick_reply);
                                    setOptions2.setText("No");
                                    String message = setOptions2.getText().toString();
                                    sendMessage(message);
                                    botsReply("OK");

                                }
                            });
                        }
                if(options=="4"){
                            setOptions1.setVisibility(View.VISIBLE);
                            setOptions2.setVisibility(View.VISIBLE);
                            setOptions3.setVisibility(View.VISIBLE);
                            setOptions4.setVisibility(View.VISIBLE);
                            setOptions1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
//
                                    setOptions1.setText("<=10");
                                    String message = setOptions1.getText().toString();
                                    String response = chat.multisentenceRespond(message);
                                    sendMessage(message);
                                    botsReply("OK");

                                }

                            });
                            setOptions2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
//                    LinearLayout lay_1 = findViewById(R.id.quick_reply);
                                    setOptions2.setText("<=20");
                                    String message = setOptions2.getText().toString();
                                    String response = chat.multisentenceRespond(message);
                                    sendMessage(message);
                                    botsReply("OK");

                                }
                            });
                            setOptions3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
//                    LinearLayout lay_1 = findViewById(R.id.quick_reply);
                                    setOptions3.setText("<=40");
                                    String message = setOptions3.getText().toString();
                                    String response = chat.multisentenceRespond(message);
                                    sendMessage(message);
                                    botsReply("OK");

                                }
                            });
                            setOptions4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
//                    LinearLayout lay_1 = findViewById(R.id.quick_reply);
                                    setOptions4.setText("<=60");
                                    String message = setOptions4.getText().toString();
                                    String response = chat.multisentenceRespond(message);
                                    sendMessage(message);
                                    botsReply("OK");

                                }
                            });
                        }




                lay_2.setVisibility(View.INVISIBLE);

                }

        } catch (JSONException e) {
            e.printStackTrace();

        }
    }


    public void copyFile(InputStream in, OutputStream out) throws IOException {

        byte[] buffer = new byte[1024];
        int read;

        while ((read = in.read(buffer)) != -1) {

            out.write(buffer, 0, read);
        }

    }

    public static boolean isSDCardAvailable() {

        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);

    }


    public void botsReply(String response) {
        ChatMessage chatMessage = new ChatMessage(false, false, response);
        adapter.add(chatMessage);
    }

    private void sendMessage(String message) {
        ChatMessage chatMessage = new ChatMessage(false, true, message);
        adapter.add(chatMessage);
    }
}
//    public String loadJSONFromAsset() {
//        String json = null;
//        try {
//            InputStream is = MainActivity.this.getAssets().open("employees.json");       //TODO Json File  name from assets folder
//            int size = is.available();
//            byte[] buffer = new byte[size];
//            is.read(buffer);
//            is.close();
//            json = new String(buffer, "UTF-8");
//        } catch (IOException ex) {
//            ex.printStackTrace();
//            return null;
//        }
//        return json;
//    }

//   private String[] getJsonFileFromLocally() {
//       String question_array[]=new String[12];
//        try {
//
//            JSONObject jsonObject = new JSONObject(loadJSONFromAsset());
//            String responseCode = jsonObject.getString("responseCode");
//            String responseMessage = jsonObject.getString("responseMessage");
//            String responseTime = jsonObject.getString("responseTime");
//
//            JSONArray questions = jsonObject.getJSONArray("question_array");                  //TODO pass array object name
//            Log.e("keshav", "m_jArry -->" + questions.length());
//            for (int i = 0; i < questions.length(); i++) {
//
//                question_array[i] = questions.getString(i);
//
//            }       // for
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//       return question_array;
//    }
//}
