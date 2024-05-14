package com.example.iosdialogdemo;



        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.view.WindowManager;
        import android.widget.AdapterView;
        import android.widget.Button;
        import android.widget.ListView;
        import android.widget.TextView;

        import java.util.ArrayList;
        import java.util.Collections;


/**
 * 国家代码
 * Created by donkor
 */
public class MainActivity extends Activity {

    private SideBar sideBar;
    private TextView dialog;
    private ListView sortListView;
    private CountryAdapter countryAdapter;
    private Button btnBack;
    private ArrayList<Country> countryList;
    /**
     * 根据拼音来排列ListView里面的数据类
     */
    private CountryPinyinComparator pinyinComparator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        pinyinComparator = new CountryPinyinComparator();

        sideBar = (SideBar) findViewById(R.id.sidrbar);
        dialog = (TextView) findViewById(R.id.dialog);
        sideBar.setTextView(dialog);
        sortListView = (ListView) findViewById(R.id.country_lvcountry);
        btnBack = (Button) findViewById(R.id.btnBack);

        countryList = new ArrayList<>();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.finish();
            }
        });

        /*
    public Country(String country, String countryCode, String sortLetters) {
        *
        * */



        countryList.add(new Country("美国","1001","A"));
        countryList.add(new Country("宋国","1001","S"));
        countryList.add(new Country("赵国","1001","Z"));

        countryList.add(new Country("扶余国","1001","F"));
        countryList.add(new Country("夜郎国","1001","Y"));
        countryList.add(new Country("天启国","1001","T"));

        countryList.add(new Country("启明国","1001","Q"));
        countryList.add(new Country("俄国","1001","E"));
        countryList.add(new Country("英吉利国","1001","Y"));


        countryList.add(new Country("法兰西国","1001","F"));
        countryList.add(new Country("西班牙国","1001","X"));
        countryList.add(new Country("葡萄牙国","1001","P"));
        countryList.add(new Country("匈牙利国","1001","X"));

        countryList.add(new Country("塞尔维亚国","1001","S"));
        countryList.add(new Country("索马里国","1001","S"));
        countryList.add(new Country("埃及国","1001","A"));

        countryList.add(new Country("苏丹国","1001","S"));
        countryList.add(new Country("哈萨克国","1001","H"));
        countryList.add(new Country("伊朗国","1001","Y"));


//        Log.e("asd", "zone.size(): " + zone.size());
        // 根据a-z进行排序源数据
        Collections.sort(countryList, pinyinComparator);
//        adapter = new SortAdapter(getActivity(), SourceDateList);

        countryAdapter = new CountryAdapter(MainActivity.this, countryList);
        sortListView.setAdapter(countryAdapter);

//        设置右侧触摸监听
        sideBar.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {

            @Override
            public void onTouchingLetterChanged(String s) {
                //该字母首次出现的位置
                int position = countryAdapter.getPositionForSection(s.charAt(0));
                if (position != -1) {
                    sortListView.setSelection(position);
                }
            }
        });

        sortListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent mIntent = new Intent(MainActivity.this, MainActivity.class);
                Bundle b = new Bundle();
                String country = countryList.get(position).getCountry();
                String countryCode = countryList.get(position).getCountryCode().replace("+","");
                b.putString("country", country);
                b.putString("countryCode", countryCode);
                mIntent.putExtras(b);
                MainActivity.this.setResult(1, mIntent);
                MainActivity.this.finish();
            }
        });
    }


}