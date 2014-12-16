package com.ui.kosanku;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class WhatsHotFragment extends Fragment {
	
	public WhatsHotFragment(){}
	
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_whats_hot, container, false);
         
        return rootView;
    }
}

/*
 package com.example.akmalgafar.httpsampleapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;
import org.json.JSONObject;

import java.io.File;
import java.net.URI;

public class AddEmployeeActivity extends Activity {
    private EditText edtName,edtEmail,edtPhone;
    private Button btnSelectPhoto,btnSubmit;
    private ImageView imgPhoto;
    public static int PICK_PHOTO = 100;

    private String SelectedImagePath ="";
    private String url = "http://maf.ui.ac.id/services/add_pegawai.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        getActionBar().setTitle("Create New");
        getActionBar().setDisplayHomeAsUpEnabled(true);

        edtEmail = (EditText) findViewById(R.id.edtAddEmail);
        edtName = (EditText) findViewById(R.id.edtAddName);
        edtPhone = (EditText) findViewById(R.id.edtAddPhone);

        btnSelectPhoto = (Button) findViewById(R.id.btnAddSelectPhoto);
        btnSubmit = (Button) findViewById(R.id.btnAddNewEmployee);
        imgPhoto = (ImageView) findViewById(R.id.imgAddEmployeePhoto);

        btnSelectPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_PHOTO);
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postToServer();
            }
        });
    }
    protected void postToServer() {
        final ProgressDialog dialog = new ProgressDialog(AddEmployeeActivity.this);
        dialog.setTitle("Post Data");
        dialog.setMessage("Please Wait...");
        dialog.show();

        String nama = edtName.getText().toString().trim();
        String email = edtEmail.getText().toString().trim();
        String phone = edtPhone.getText().toString().trim();

        String path =  SelectedImagePath;
        Log.d("HTTP_APP", path);
        File filePath = new File(path);

        RequestParams requestParams = new RequestParams();
        requestParams.put("nama",nama);
        requestParams.put("email",email);
        requestParams.put("phone",phone);

        try {
            requestParams.put("userfile",filePath);

        } catch (Exception e) {

        }
        AsyncHttpClient client = new AsyncHttpClient();
        client.setTimeout(6000);
        client.post(url,requestParams,new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                dialog.dismiss();
                fetchResponse(new String(responseBody));
            }


            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                   dialog.dismiss();
                Toast.makeText(AddEmployeeActivity.this, "gagal", Toast.LENGTH_LONG).show();
            }
        });
    }
    protected void fetchResponse(String response){
        try{
            JSONObject object = new JSONObject(response);
            if(object.getString("status").equals("ok")){
                Toast.makeText(AddEmployeeActivity.this,object.getString("message"),Toast.LENGTH_LONG).show();
            }
        }
        catch (Exception e){

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            Uri selectedImageUri= data.getData();

            SelectedImagePath= Utils.getRealPathFromURI(AddEmployeeActivity.this,selectedImageUri);
            imgPhoto.setImageURI(selectedImageUri);
        }
    }

    public static void toAddEmployeeActivty(Activity activity){
        activity.startActivityForResult(new Intent(activity,AddEmployeeActivity.class),PICK_PHOTO);
    }
} 
 */

/*
package com.example.akmalgafar.httpsampleapp;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class EmployeeAdapter extends BaseAdapter {

    ArrayList<Employee> listEmployee;
    Activity activity;

    public EmployeeAdapter(ArrayList<Employee> listEmployee,Activity activity){
        this.activity = activity;
        this.listEmployee = listEmployee;
    }

    @Override
    public int getCount() {
        return listEmployee.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View view = convertView;
        ViewHolder holder = null;
        if(view==null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.inf_item_employee,null);
            holder.imgPhoto = (ImageView)view.findViewById(R.id.imgItemEmployeePhoto);
            holder.txtName = (TextView)view.findViewById(R.id.txtItemEmployeeName);
            holder.txtEmail = (TextView)view.findViewById(R.id.txtItemEmployeeEmail);
            holder.txtPhone = (TextView)view.findViewById(R.id.txtItemEmployeePhone);
            view.setTag(holder);
        }else
        {
            holder = (ViewHolder) view.getTag();
        }
        holder.txtName.setText(listEmployee.get(i).getNama());
        holder.txtEmail.setText(listEmployee.get(i).getEmail());
        holder.txtPhone.setText(listEmployee.get(i).getPhone());

        Picasso.with(activity).load(listEmployee.get(i).getPhoto()).error(R.drawable.ic_launcher).into(holder.imgPhoto);

        return view;
    }
    static class ViewHolder{
        ImageView imgPhoto;
        TextView txtName,txtEmail,txtPhone;
    }
}
 */
