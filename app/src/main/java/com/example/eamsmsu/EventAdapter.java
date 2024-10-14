package com.example.eamsmsu;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eamsmsu.model.Event;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {


   private Context context;

   private List<Event> eventList;


    public EventAdapter(Context context, List<Event> eventList) {
        this.context = context;
        this.eventList = eventList;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_event, parent, false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {

        Event event = eventList.get(position);
        holder.tvTitleEvent.setText(event.getTitleEvent());
        holder.tvVenue.setText(event.getVenue()  + " - " + event.getDuration());
        holder.tvDate.setText(event.getDateTimeEvent());
        holder.tvCourse.setText(event.getSemester()+" - " + event.getProgram());


        holder.cardView.setOnClickListener(v -> {
            Intent intent = new Intent(context, StudentAttendanceActivity.class);
            intent.putExtra("event", event);
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public class EventViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitleEvent, tvVenue, tvDate, tvCourse;
        private CardView cardView;
        public EventViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardViewEvent);
            tvTitleEvent = itemView.findViewById(R.id.tvTitle);
            tvVenue = itemView.findViewById(R.id.textView);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvCourse = itemView.findViewById(R.id.tvCourse);

        }
        // ...
    }
}
