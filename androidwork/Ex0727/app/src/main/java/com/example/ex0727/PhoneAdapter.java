package com.example.ex0727;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PhoneAdapter extends BaseAdapter {
    //BaseAdapter-listview를 커스텀하고 싶을 때 상속 받아서 구현하게 되는 클래스
    //필요한 부분을 수정하고 사용할 수 있도록 안드로이드에서 제공하는 기본 어댑터
  //Adapter가 하는 일
    // 템플릿 + 데이터 => listView에 한칸한칸 적재
    // xml 파일가지고 눈에 보이는 뷰로 만드는 작업 inflate고 부르는데
    // inflate작업은 Activity만 할 줄 암
    // xml => 눈에 보이게 만드는 일 => inflate
    // Activity에 도움을 받아서 inflate를 추출해야함
    //inflater : xml가지고 눈에 보이는 뷰로 만드는 작업
    //inflater작업은 Activity만 가능
    //Activity에서 inflate를 할 수 있는 객체를 뽑아다가 adapter안에서 작업을 수행
    //Activity의 도움을 받아야함

    private Context context; // inflater 추출하기 위해서 받아온 현재 Activity정보(화면정보)
    private LayoutInflater inf; // xml을 눈에 보이게 하는 도구(전달받은 Context를 추출한 inflate를 저장할 변수)
    //inflate하는 예(findViewbyid,setConetextView)
    private int layout; // 템플릿
    private ArrayList<PhoneVO> data; // 데이터

    public PhoneAdapter(Context context, int layout,ArrayList<PhoneVO>data){
           this.context = context;
           this.inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           //PhoneAdapter는 BaseAdapter를 상속받고있기 때문에 더 이상 ACtivity가 될 수 없음
        //지금 xml을 눈에 보이게 만드는 layoutinflater가 필요 ->Main에서 context정보를 받아다가
        //getSystemService 시스템 서비스를 추출하겠다. LAYOUT_INFLATER_SERVICE를 추출하겠다
        //센서 추출할때 많이 씀
        //getSystemService가 Object로 리턴하는데 다운캐스팅을해야해서 LayoutInflater를 해줌
           this.layout = layout; //템플릿
           this.data = data; //데이터
    }

   //어댑터 커스텀할 때 필요한 4가지 오버라이딩
    @Override
    public int getCount() {
        // ListView 항목 개수를 지정
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        // position번째 data를 반환
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        //position 번째 id를 반환
        return position; //의례적으로 position이라고 적음
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //★★★★★
        // getView는 한줄을 만들때마다 호출(한줄을 만들때마다 inflate를 시키면 버벅거림 시간지체)
        //첫번째 항목을 만들때만 inflate시킴
        //첫번째 항목에 만들었던 view에다가 이미지랑,이름이랑,번호만 갈아끼움(이미만들어진 뷰(converView)재활용)

        // 1.position => 항목의 번호
        // 2.convertView => 이전에 만들어진 View(xml을 눈에 보이는 형태로 바꾼 것)
        // 3.parent =>모든 뷰를 담고 있는 ListView

        // 첫번째 항목을 만드려고 한다면! => 첫번째 연락처를 띄우려고 한다면!
        if(convertView == null) { //position == 0 //첫번째 항목을 그리는 중이라면,이전에 뷰가 없다면
            convertView = inf.inflate(layout, parent, false);
            //1.내가 inflate하고 싶은 layout id,2.layout을 적재하고 싶은 view,listview(parent)에 있는 속성을
            //3. inflate시킬려는 layout이 속성값 그대로 가져다 쓸것인지 작성

        } // xml -> 눈에 보이는 형태(View)로 변환

        // arrayList에 들어있는 Data로 한줄한줄 꾸며주기

        // 템플릿에 들어있는 textVew찾아오기
        //PhoneAdapter는 findviewbyid(Activity에 내장된 메소드)를 할 수 없다.
        TextView tv_name = convertView.findViewById(R.id.tv_name);
        tv_name.setText(data.get(position).getName()); //이름

        // 전화번호,이미지 지정
        TextView tv_number = convertView.findViewById(R.id.tv_number);
        tv_number.setText(data.get(position).getNumber());//전화번호

        ImageView img = convertView.findViewById(R.id.img);
        img.setImageResource(data.get(position).getImgID());//이미지

        // 항목을 하나하나 추가할 때마다 findViewById를 하면 Android가 힘겨워 할 수 있음
        // => 첫번째 convertView 만들때만 findViewById를 하고 다음부터는 저장된 View를 꺼내다 쓰자
        // => ViewHolder 패턴
        // => RecyclerView

       return convertView;//만들어진 뷰를 리턴할테니 리스트뷰에 한줄 한줄 넣어라

    }

}
