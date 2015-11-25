package c.myapplication;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import com.astuetz.PagerSlidingTabStrip;

public class MainActivity extends AppCompatActivity {

  private Toolbar toolbar;
  private ImageView imageView;
  private CollapsingToolbarLayout collapsingToolbar;
  private ViewPager mViewPager;
  private PagerSlidingTabStrip tabStrip;
  private TabPagerAdapter adapter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    toolbar = (Toolbar) findViewById(R.id.appbar);
    setSupportActionBar(toolbar);
    adapter = new TabPagerAdapter(getSupportFragmentManager());
    mViewPager = (ViewPager) findViewById(R.id.viewpager);
    collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
    tabStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
    mViewPager.setAdapter(adapter);
    tabStrip.setViewPager(mViewPager);


  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  class TabPagerAdapter extends FragmentStatePagerAdapter {

    public TabPagerAdapter(FragmentManager fm) {
      super(fm);
    }

    @Override public Fragment getItem(int position) {

      SampleFragment sampleFragment = SampleFragment.newInstance((++position) + "");
      return sampleFragment;
    }

    @Override public int getCount() {
      return 2;
    }

    @Override public CharSequence getPageTitle(int position) {
      return "Dummy Tab " + (++position);
    }
  }
}
