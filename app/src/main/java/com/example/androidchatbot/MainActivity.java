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
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.androidchatbot.Adapter.ChatMessageAdapter;
import com.example.androidchatbot.Model.ChatMessage;

//import org.alicebot.ab.AIMLProcessor;
//import org.alicebot.ab.Bot;
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

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    RelativeLayout mainLayout;
    LayoutInflater inflater;
    View myLayout ;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    LinearLayout sndmessage;
    int flag;
    String message;
    int i;
    public Question[] obj;
    String que1;
    String options1;
    int x;

    ListView listView;

    FloatingActionButton btnSend;
    EditText edtTextMsg;
    ImageView imageView;

    private Bot bot;
    public static Chat chat;
    private ChatMessageAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainLayout= findViewById(R.id.activity_main_layout);
//        inflater=getLayoutInflater();
//        myLayout = inflater.inflate(R.layout.quick_reply_layout, mainLayout, false);
        sndmessage = findViewById(R.id.send_message_layout);
        /* sndmessage.setVisibility(View.INVISIBLE); */
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);
        flag=0;
        listView = findViewById(R.id.listView);
        btnSend = findViewById(R.id.btnSend);
        edtTextMsg = findViewById(R.id.edtTextMsg);
        imageView = findViewById(R.id.imageView);

        adapter = new ChatMessageAdapter(this, new ArrayList<ChatMessage>());
        listView.setAdapter(adapter);

//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                message = button1.getText().toString();
//                sendMessage(message);
//                botsReply("OK");
//                flag++;
//            }
//        });
//        btnSend.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String message=edtTextMsg.getText().toString();
//
//                String response = chat.multisentenceRespond(edtTextMsg.getText().toString());
//
//                if(TextUtils.isEmpty(message)) {
//                    Toast.makeText(MainActivity.this, "Please Enter a query", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                sendMessage(message);
//                botsReply("OK");
//                edtTextMsg.setText("");
//                listView.setSelection(adapter.getCount() - 1);
//            }
//        });

//        botsReply("Sorry! No initial report available");
//
//        botsReply("Location of casualty?");
//        btnSend.setOnClickListener(this);
//
//        botsReply("Number of people died?");
//        btnSend.setOnClickListener(this);
//
//        botsReply("Number of cattle death?");
//        button1.setVisibility(View.VISIBLE);
//        button2.setVisibility(View.VISIBLE);
//        button3.setVisibility(View.VISIBLE);
//        button4.setVisibility(View.VISIBLE);
//        button1.setEnabled(true);
//        button2.setEnabled(true);
//        button3.setEnabled(true);
//        button4.setEnabled(true);
//        button1.setText("30");
//        button1.setText("40");
//        button1.setText("50");
//        button1.setText("60");
//        button1.setOnClickListener(this);
//        button2.setOnClickListener(this);
//        button3.setOnClickListener(this);
//        button4.setOnClickListener(this);
//
//        botsReply("Number Of injured?");
//        button1.setEnabled(true);
//        button2.setEnabled(true);
//        button3.setEnabled(true);
//        button4.setEnabled(true);
//        button1.setVisibility(View.VISIBLE);
//        button2.setVisibility(View.VISIBLE);
//        button3.setVisibility(View.VISIBLE);
//        button4.setVisibility(View.VISIBLE);
//        button1.setText("10");
//        button1.setText("30");
//        button1.setText("40");
//        button1.setText(">50");
//        button1.setOnClickListener(this);
//        button2.setOnClickListener(this);
//        button3.setOnClickListener(this);
//        button4.setOnClickListener(this);
//
//        botsReply("Any old aged person injured?");
//        button1.setEnabled(true);
//        button2.setEnabled(true);
//        button1.setVisibility(View.VISIBLE);
//        button2.setVisibility(View.VISIBLE);
//        button1.setText("YES");
//        button2.setText("NO");
//        button1.setOnClickListener(this);
//        button2.setOnClickListener(this);

//        botsReply("How many?");
//        btnSend.setOnClickListener(this);
//
//        botsReply("Number of missing?");
//        button1.setEnabled(true);
//        button2.setEnabled(true);
//        button3.setEnabled(true);
//        button4.setEnabled(true);
//        button1.setVisibility(View.VISIBLE);
//        button2.setVisibility(View.VISIBLE);
//        button3.setVisibility(View.VISIBLE);
//        button4.setVisibility(View.VISIBLE);
//        button1.setText("10");
//        button1.setText("20");
//        button1.setText("30");
//        button1.setText("40");
//        button1.setOnClickListener(this);
//        button2.setOnClickListener(this);
//        button3.setOnClickListener(this);
//        button4.setOnClickListener(this);
//
//        botsReply("Any child missing?");
//        button1.setEnabled(true);
//        button2.setEnabled(true);
//        button1.setVisibility(View.VISIBLE);
//        button2.setVisibility(View.VISIBLE);
//        button1.setText("YES");
//        button2.setText("NO");
//        button1.setOnClickListener(this);
//        button2.setOnClickListener(this);
//
//        botsReply("How many?");
//        btnSend.setOnClickListener(this);

//

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

    public void parseJson(String s) {
//        StringBuilder builder = new StringBuilder();
        try {
            JSONObject root = new JSONObject(s);
            String fir = root.getString("fir");
            botsReply(fir);
            JSONArray question_dict = root.getJSONArray("question_dict");


            for (i = 0; i < question_dict.length(); i++) {
                Log.d("flag", String.valueOf(flag));
                JSONObject ques = question_dict.getJSONObject(i);
                String que = ques.getString("que");

                String options = ques.getString("options");
//                LinearLayout lay_2 = findViewById(R.id.quick_reply);
                String choice_array[] = new String[4];
                Log.d("souvik ", options);
                Log.d("souvik5",que);
                if (!options.contains("0")) {
                    JSONArray choices = ques.getJSONArray("choices");
                    for (int j = 0; j < choices.length(); j++) {
                        choice_array[j] = choices.get(j).toString();
                    }
                }
                flag++;
                Question obj1 = new Question(que,options,choice_array);
                Log.d("souvik2",obj1.getQuestion());
                botsReply(obj1.getQuestion());
                switch(obj1.getOptions()){
                    case "0": sndmessage.setVisibility(View.VISIBLE);
                              btnSend.setOnClickListener(this);
                              break;
                    case "2": button1.setVisibility(View.VISIBLE);
                              button2.setVisibility(View.VISIBLE);
                              button1.setText(choice_array[0]);
                              button2.setText(choice_array[1]);
                              button1.setEnabled(true);
                              button2.setEnabled(true);
                              button1.setOnClickListener(this);
                              button2.setOnClickListener(this);
                              break;
                    case "4": button1.setVisibility(View.VISIBLE);
                                button2.setVisibility(View.VISIBLE);
                                button3.setVisibility(View.VISIBLE);
                                button4.setVisibility(View.VISIBLE);
                                button1.setEnabled(true);
                                button2.setEnabled(true);
                                button3.setEnabled(true);
                                button4.setEnabled(true);
                                button1.setText(choice_array[0]);
                                button2.setText(choice_array[1]);
                                button3.setText(choice_array[2]);
                                button4.setText(choice_array[3]);
                                button1.setOnClickListener(this);
                                button2.setOnClickListener(this);
                                button3.setOnClickListener(this);
                                button4.setOnClickListener(this);


                }
            }


//                LinearLayout sndmessage = findViewById(R.id.send_message_layout);
//            x=0;







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

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button1:
                message = button1.getText().toString();
                sendMessage(message);
                botsReply("OK");
                flag++;
//                mainLayout.removeView(myLayout);

                break;
            case R.id.button2:
                message = button2.getText().toString();
                sendMessage(message);
                botsReply("OK");
                flag++;
//                mainLayout.removeView(myLayout);


                break;
            case R.id.button3:
                message = button3.getText().toString();
                sendMessage(message);
                botsReply("OK");
                flag++;
//                mainLayout.removeView(myLayout);


                break;
            case R.id.button4:
                message = button4.getText().toString();
                sendMessage(message);
                botsReply("OK");
                flag++;

//                mainLayout.removeView(myLayout);

//                break;
            case R.id.btnSend:
//                        String message = edtTextMsg.getText().toString();

                        String response = chat.multisentenceRespond(edtTextMsg.getText().toString());

                        if (TextUtils.isEmpty(message)) {
                            Toast.makeText(MainActivity.this, "Please Enter a query", Toast.LENGTH_SHORT).show();
                            return;
                        }
                flag++;
                        sendMessage(message);
                        botsReply("OK");
                        edtTextMsg.setText("");

                        listView.setSelection(adapter.getCount() - 1);
                        break;
        }
        button1.setVisibility(View.INVISIBLE);
        button2.setVisibility(View.INVISIBLE);
        button3.setVisibility(View.INVISIBLE);
        button4.setVisibility(View.INVISIBLE);
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);


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
