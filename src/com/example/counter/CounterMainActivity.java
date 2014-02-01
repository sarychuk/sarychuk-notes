package com.example.counter;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class CounterMainActivity extends Activity {

	public final static String EXTRA_MESSAGE = "com.example.counter.MESSAGE";
	public final String FILENAME = "Counter.sav";
	
	private ArrayList<CounterModel> counterModels = CounterList.getList();
	private ArrayAdapter<CounterModel> counterModelAdapter;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        updateListView();
    }    

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
 	protected void onResume() {
 		// TODO Auto-generated method stub
 		super.onResume();
 		
 		updateListView();   
 	}
    
    /** Called when the user clicks the add button */
    public void newCounter(View addbutton){
        EditText counterName = (EditText)findViewById(R.id.counterName);
        String title = counterName.getText().toString();
        counterModels.add(new CounterModel(title));
        counterName.setText("");
        updateListView();
}
    
    private void updateListView() {
        //Called by OnCreate, On Resume, and on the add counter button
    	counterModelAdapter = new listAdapter();
        ListView list = (ListView) findViewById(R.id.counterListView);
        list.setAdapter(counterModelAdapter);
    }
    
  //Custom List View from http://www.youtube.com/watch?v=WRANgDgM2Zg
    private class listAdapter extends ArrayAdapter<CounterModel> {
        public listAdapter(){
                super(CounterMainActivity.this, R.layout.counter, counterModels);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
                View itemView = convertView;
                if (itemView == null){
                        itemView = getLayoutInflater().inflate(R.layout.counter, parent, false);
                }
                
                //find the counter to work with
                CounterModel currentCounter = counterModels.get(position);
                //Fill the view
                TextView cTitle = (TextView)itemView.findViewById(R.id.counterName);
                cTitle.setText(currentCounter.getCounterName());
                
                TextView cCount = (TextView)itemView.findViewById(R.id.counterCount);
                cCount.setText(currentCounter.getCounterCount().toString());
                
                Button buttonGTC = (Button)itemView.findViewById(R.id.buttonCounter);
                //tag will later be used to launch the counterpage activity
                buttonGTC.setTag(position);
                
                buttonGTC.setOnClickListener(new View.OnClickListener() {
                        
                        @Override
                        public void onClick(View v) {
                                // TODO Auto-generated method stub
                                
                        	Intent intent = new Intent(CounterMainActivity.this, DisplayCounterActivity.class);
                            Integer indexpos = (Integer)v.getTag();
                            intent.putExtra("index", indexpos) ;
                            startActivity(intent);
                                
                                //String message = "You clicked position" + v.getTag();
                                //Toast.makeText(CounterArrayActivity.this, message, Toast.LENGTH_LONG).show();
                        }
                });
                

                return itemView;
        }                
}
    
    
    
}
