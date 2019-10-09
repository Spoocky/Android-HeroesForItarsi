package co.fajri.myhero;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.MenuList> {
    private ArrayList<Hero> listHero;
    private Context context;


    public HeroAdapter(ArrayList<Hero> list){
        this.listHero = list;
    }

    //menginisiasi adapter ke layout row_hero
    @NonNull
    @Override
    public HeroAdapter.MenuList onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_hero, viewGroup, false);
        return new MenuList(view);
    }

    //memasang data ke layout row_hero
    @Override
    public void onBindViewHolder(@NonNull final MenuList holder, final int position) {
        //Mengambil data dari listHero<Hero>
        Hero hero = listHero.get(position);

        //mengambil gambar dari internet
        Glide.with(holder.itemView.getContext())
                .load(hero.getFoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.foto);

        //mengambil data dari HeroesData
        holder.tvNama.setText(hero.getNama());
        holder.tvDetail.setText(hero.getDetail());

        //mengaktifkan onClickListener
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context = v.getContext();
                //memindahkan ke DetailHero
                Intent intent = new Intent(context,DetailHero.class);
                //melempar data posisi ke DetailHero
                intent.putExtra(DetailHero.POSITION,position);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return listHero.size();
    }

    //mengalamatkan tujuan tempat pemasangan
    public class MenuList extends RecyclerView.ViewHolder {
        ImageView foto;
        TextView tvNama, tvDetail;

        public MenuList(@NonNull View itemView) {
            super(itemView);
            foto = itemView.findViewById(R.id.img_foto);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvDetail = itemView.findViewById(R.id.tv_detail);
        }
    }
}
