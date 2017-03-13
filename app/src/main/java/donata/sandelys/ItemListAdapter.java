package donata.sandelys;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import donata.sandelys.model.Item;

class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemViewHolder> {
	private final OnItemClickListener listener;
	private       List<Item>          itemList;

	ItemListAdapter(List<Item> itemList, OnItemClickListener listener) {
		this.itemList = itemList;
		this.listener = listener;
	}

	@Override public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return new ItemViewHolder(LayoutInflater.from(parent.getContext())
		                                        .inflate(R.layout.item_cell, parent, false), listener);
	}

	@Override public void onBindViewHolder(ItemViewHolder holder, int position) {
		holder.bind(itemList.get(position));
	}

	@Override public int getItemCount() {
		return itemList.size();
	}

	void setItems(List<Item> searchedItems) {
		this.itemList = searchedItems;
	}

	interface OnItemClickListener {
		void onItemClick(Item item);
	}

	static class ItemViewHolder extends RecyclerView.ViewHolder {
		private final OnItemClickListener listener;
		private final TextView            title;
		private final TextView            price;

		ItemViewHolder(View itemView, OnItemClickListener listener) {
			super(itemView);
			this.listener = listener;
			title = (TextView) itemView.findViewById(R.id.title);
			price = (TextView) itemView.findViewById(R.id.price);
		}

		void bind(final Item item) {
			itemView.setOnClickListener(new View.OnClickListener() {
				@Override public void onClick(View view) {
					listener.onItemClick(item);
				}
			});
			title.setText(item.name);
			price.setText(String.valueOf(item.price) + "€");
		}
	}
}
