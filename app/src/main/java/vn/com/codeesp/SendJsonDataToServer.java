package vn.com.codeesp;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;

class SendJsonDataToServer extends AsyncTask<String, String, String> {
    String JsonResponse = null;
    ProgressDialog dialog;


    @Override
    protected void onPreExecute() {
        super.onPreExecute();

//        dialog = new ProgressDialog(TwoAnswerScreenActivity.this);
//        dialog.setMessage("Please Wait...");
//        dialog.setCancelable(false);
//        dialog.show();


    }


    @Override
    protected String doInBackground(String... params) {

        String JsonDATA = params[0];
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        try {
            URL url = new URL("http://192.168.1.104/");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            // is output buffer writter
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestProperty("Accept", "application/json");
//set headers and method
            Writer writer = new BufferedWriter(new OutputStreamWriter(urlConnection.getOutputStream(), "UTF-8"));
            writer.write(JsonDATA);
// json data
//                Log.e("Response", JsonResponse + "");
            writer.close();
            InputStream inputStream = urlConnection.getInputStream();
//input stream
            StringBuffer buffer = new StringBuffer();
            if (inputStream == null) {
                // Nothing to do.
                return null;
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String inputLine;
            while ((inputLine = reader.readLine()) != null)
                buffer.append(inputLine + "\n");
            if (buffer.length() == 0) {
                // Stream was empty. No point in parsing.
                return null;
            }
            JsonResponse = buffer.toString();
            Log.e("Response", JsonResponse + "");
//response data
            Log.i("Tag", JsonResponse);
            //send to post execute

            return JsonResponse;
//                return null;


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (final IOException e) {
                    Log.e("Tag", "Error closing stream", e);
                }
            }
        }
        return null;
    }


    @Override
    protected void onPostExecute(String s) {


        if (JsonResponse != null) {
//            dialog.dismiss();
            //Your success code
        }


    }

}