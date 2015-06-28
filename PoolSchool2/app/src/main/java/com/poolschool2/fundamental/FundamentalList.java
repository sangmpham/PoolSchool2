package com.poolschool2.fundamental;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.poolschool.poolschool.R;

import java.util.ArrayList;

public class FundamentalList extends Activity {
    ArrayList<FundamentI> imageList =  new ArrayList<FundamentI>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fundamental_list);

      populateFundamentalI();
      populateListView();




    }

    private void populateFundamentalI(){
        imageList.add(new FundamentI(R.drawable.hold1, "Hold the pool cue at your hip with your dominant hand. Place one hand at the point on the stick close to the rear where it is balanced. There will usually be tape there. Place your hand approximately 4 to 5 inches (10.2 to 12.7 cm) back. Ideally, your back hand should be at a 90-degree angle with your cue."));
        imageList.add(new FundamentI(R.drawable.hold2, "Lower yourself to the table. Once you grip the cue with your dominant hand and find your shot, you should lower your body toward the table, so you're staring down the line of the cue ball. You won't be able to make your shot if you're stiff and upright"));
        imageList.add(new FundamentI(R.drawable.hold3,"Make an open bridge with your other hand. Place your other hand about 6-8 inches (15-20 cm) away from the cue ball down on the table. The closer you are to the ball, the more precision you'll have with your shot. Once your hand is down, you will make a bridge, or a cradle with your hand that will allow you to balance the cue on your hand and hit your shots. Though certain bridges work better in certain situations, it's best to be familiar with the most common bridge, the open bridge, first"));
        imageList.add(new FundamentI(R.drawable.hold4, "Hold the cue steadily as you \"eye\" up the target ball. Lean forward and mentally place the cue on the spot on the cue ball that you want to hit. Techniques for hitting the cue ball in the right spot for specific shots can be perfected later. Ideally, you should hit that cue ball in its center, or on the \"sweet spot\" of the ball, so it goes where it needs to go."));
        imageList.add(new FundamentI(R.drawable.hold5, "Hold the pool cue at the balance point and take your shot. Slide the cue forward while aiming steadily. If you feel uncertain about the shot, then you can gently move the cue back and forth on your bridge to feel more steady and balanced before you take your shot instead of trying to take your shot right away. Remember that you want to stroke the ball, not poke it. Follow through with your shot by continuing your motion slightly after taking the shot"));
        imageList.add(new FundamentI(R.drawable.hold6, "Use the closed bridge. The closed bridge is a more advanced technique that can be used for more accented shots. Needless to say, it will also help you look more like a pro, but it's important to do it right. Here's what you need to do:\n" +
                "\n" +
                "    Place your front hand on the table while making a fist.\n" +
                "    Spread your pinkie, ring, and middle finger while leaving your index finger tucked.\n" +
                "    Lift your index finger and slide the thumb underneath it.\n" +
                "    Slide your index finger over your thumb to create a loop.\n" +
                "    Place your cue through the loop, while keeping the tip of your thumb pressed against the tip of your index finger"));
        imageList.add(new FundamentI(R.drawable.hold7, " Use a rail bridge when the cue ball is 4-6 inches (10-15 cm) away from the rail. This bridge can be helpful when you don't have enough room to make a traditional bridge because the ball is too close to the end of the table. Here's how you do it:\n" +
                "\n" +
                "    Place your hand on the rail itself.\n" +
                "    Lift your index finger over your thumb and place it on the other side of the cue stick, so that your thumb is on one side of the stick and your index finger is on the other.\n" +
                "    Use the rail for bottom stability. Take your shot.\n" +
                "\n"));
        imageList.add(new FundamentI(R.drawable.hold8, "Use a rail bridge when the cue ball is just 1-2 inches or so (2.5-5 cm) away from the rail. If the ball is so close to the rail that even the traditional rail bridge is not possible, then you can use a different version of the rail bridge to make your shots. Place your palm against the edge of the rail.Place your index finger flat over the rail, guiding the cue on one side.Place the tip of your thumb on the other side to guide the cue on the other side.This time, your thumb and index fingers will be in their normal positions, with the cue in the middle.Take your shot, using the rail for bottom support"));
        imageList.add(new FundamentI(R.drawable.hold9, "Use an elevated bridge to elevate over a ball. This can help you hit that cue ball when it is being nearly blocked by another ball. Here is all you have to do to hit this shot: Plant your index finger down on the table, almost perpendicular to it.Plant down your pinkie finger while tucking your middle and ring fingers under, forming a tripod.Lift your thumb upwards, forming a v-channel between your thumb and index finger in the air.Place the cue between your thumb and index finger and take your shot."));

    }



    private void populateListView(){
        ArrayAdapter<FundamentI> adapter = new MyListAdapter();
        ListView list = (ListView) findViewById(R.id.fundListView);
        list.setAdapter(adapter);
    }
private class MyListAdapter extends ArrayAdapter{
    public MyListAdapter(){
        super(FundamentalList.this, R.layout.fundlistviewstruct,imageList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View itemView = convertView;
        if(itemView == null){
            itemView = getLayoutInflater().inflate(R.layout.fundlistviewstruct, parent, false);
        }

        FundamentI  currentFundamental = imageList.get(position);


        //find the view
        ImageView imageView = (ImageView) itemView.findViewById(R.id.fundImageView);
        imageView.setImageResource(currentFundamental.getImage());

        TextView makeText=(TextView) itemView.findViewById(R.id.fundTextView);
        makeText.setText(currentFundamental.getText());
        return itemView;

    }
}

}
