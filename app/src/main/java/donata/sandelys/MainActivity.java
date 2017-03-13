package donata.sandelys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import donata.sandelys.model.Item;

public class MainActivity extends AppCompatActivity implements ItemListAdapter.OnItemClickListener, TextWatcher {

	private List<Item>      itemList;
	private ItemListAdapter adapter;

	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		EditText searchInput = (EditText) findViewById(R.id.search_input);
		searchInput.clearFocus();
		searchInput.addTextChangedListener(this);

		initData();
	}

	private void initData() {
		itemList = new ArrayList<>();
		itemList.add(new Item("Kvapusis vanduo Lanvin Eclat D'Arpege EDP moterims 100 ml",
		                      "Lanvin Eclat D'Arpege kvepalų moterims aromatas – subtilus ir vaiskus.\n" + "\n" + "Iš pradžių pasklinda alyvų ir sicilinių citrinų lapų kvapas, kurį lydi švelnus visterijų žiedų, lengvutis žalių arbatos lapelių, sodrus persikų žiedų, geismą žadinantis rausvažiedžių bijūnų ir be galo skanus kininių kvepenių aromatas. Galiausiai apgaubia libaninių kedrų, lengvas muskuso ir prabangus ambros dvelksmas, jaudinantis tarsi švelni glamonė.",
		                      29.99f));
		itemList.add(new Item("Tualetinis vanduo Calvin Klein CK IN2U Her EDT moterims 150 ml",
		                      "Seksualumą ir spontaniškumą žadinantys madingi Calvin Klein ckIN2U kvepalai moterims išreiškia jaunų žmonių laisvę ir galimybes tyrinėti pasaulį. Jaunatviškas ir seksualus jų aromatas slypi paprasto, bet patrauklaus minimalistinio dizaino flakone.\n" + "\n" + "Calvin Klein ckIN2U kvepalų moterims aromatas skleidžia gaivų gėlių ir rytietišką medienos kvapą. Iš pradžių užplūsta greipfrutų, bergamočių ir raudonųjų serbentų lapų kvapas, pereinantis į randenių ir baltažiedžių kaktusų aromatą. Galiausiai apgaubia ambros, kadagių ir vanilės dvelksmas.",
		                      20.00f));
		itemList.add(new Item("Kūno pienelis Calvin Klein Deep Euphoria moterims 200 ml",
		                      "Calvin Klein Deep Euphoria tai dar labiau gundantis Euphoria kolekcijos aromatas. \n" + "\n" + "Sukurti Calvin Klein Deep Euphoria moterims įkvėpė noras įkūnyti Jūsų slapčiausius troškimus. Jų aromatas seksualus, gundantis, paslaptingas, žavingas ir provokuojantis.",
		                      19.99f));
		itemList.add(new Item("Tualetinis vanduo Guess Seductive EDT moterims 75 ml",
		                      "Tai ypatingas kvapas, apimantis visko po truputį. Kvapas skleidžia jausmingą kriaušės, jazminų, apelsino aromatą, švelnų ir jaukų vanilės, kašmyro medžio, juodųjų serbentų aromatus.\n" + "\n" + "- Pradinės natos: bergamotės, juodieji serbentai, kriaušės;\n" + "- Vidurinės natos: jazminai, apelsinų žiedai, vilkdalgis;\n" + "- Pagrindinės natos: vanilė, kašmyro medis, aromatinė Bosvelijų derva.",
		                      59.99f));
		itemList.add(new Item("Tualetinis vanduo David Beckham Intimately EDT vyrams 75 ml",
		                      "Iššaukiantis, seksualus, šiuolaikiškas, jausmingas ir šiltas David Beckham Intimately aromatas vyrams.\n" + "\n" + "Energingas ir kartu raminantis kvapas atskleidžia seksualiąją David'o Beckham'o pusę. Provokuojantis, gaivus, modernus kvapas vienija šiltus medienos, prieskonių akordus.\n" + "\n" + "- Viršutinės natos: greipfrutai, bergamotės, kardamonas;\n" + "- Vidurinės natos: muskatas, žibutės, žvaigždanyžis;\n" + "- Pagrindinės natos: santalmedis, ambra, pačiuliai.",
		                      69.99f));
		itemList.add(new Item("Kvapusis vanduo Elizabeth Arden Ardenbeauty EDP moterims 100 ml",
		                      "Elizabeth Arden Ardenbeauty kvepalų moterims aromatas – toks pat daugialypis, kaip ir juo besikvėpinanti moteris. Kiekviena moteris yra savaip žavi ir turi savitą stilių, nes nėra vieno universalaus grožio apibūdinimo. Grožis – realybės ir iliuzijų derinys – visada išimtinai moteriškas.\n" + "\n" + "Gaivus žalumynais ir gėlėmis dvelkiantis Elizabeth Arden Ardenbeauty kvepalų moterims aromatas – be galo viliojantis. Iš pradžių plūsteli gaivinantis ryškus ryžių žiedų kvapas. Po to pasklinda sodrus ir elegantiškas žydrųjų vandens lelijų, orchidėjų ir lelijų aromatas. Galiausiai apgaubia šiltas geismą žadinantis baltųjų santalų, ambros ir muskuso dvelksmas.",
		                      39.99f));
		itemList.add(new Item("Kvapusis vanduo Elizabeth Arden Splendor EDP moterims 125 ml",
		                      "Itin moteriškas iš gėlių ir vaisių kvapo supintas Elizabeth Arden Splendor kvepalų moterims aromatas švelniai glamonėja odą. Jis spinduliuoja džiaugsmą ir idealiai tinka kvepintis romantiškomis progomis.\n" + "\n" + "Iš pradžių pasklidęs obuolių, bergamočių ir ananasų kvapas susilieja su pakalnučių, rožių ir jazminų aromatu. Galiausiai apgaubia vos juntamas santalų, muskuso, kedrų ir ambros dvelksmas. Dėl šio unikalaus gėlių, vaisių ir rytietiškų kvapų derinio Elizabeth Arden Splendor kvepalai moterims yra be galo moteriški, o jų aromatas ilgai neišblėsta.",
		                      99.99f));
		itemList.add(new Item("Kvapusis vanduo Elizabeth Arden 5th Avenue After Five EDP moterims 125 ml",
		                      "Šiuolaikiškas rytietiškas Elizabeth Arden 5th avenue after five kvepalų moterims aromatas leidžia lengvai užbaigti dieną ir pradėti vakarą.\n" + "\n" + "Po 5-ių… diena ką tik baigėsi, kažkur sklinda muzika ir garsioji Niujorko 5-oji aveniu pagyvėja, įelektrinta atmosfera prisipildo romantiškų lūkesčių, žadančių aistringą vakarą. Vakarėlis dar tik prasideda…\n" + "\n" + "Vaiskus šiuolaikiškas Elizabeth Arden 5th avenue after five kvepalų moterims aromatas – neįtikėtinai žadinantis geismą ir visiškai nenuspėjamas – supintas iš arabinių jazminaičių, slyvų ir Indijoje augančių orchidėjų kvapo. Iš pradžių pasklinda gaivus juodųjų slyvų nektaro kvapas, sumišęs su kalendrų ir bergamočių dvelksmu. Po to pakvimpa arabiniais jazminaičiais ir rasotais pakalnučių žiedais. Galiausiai apgaubia geismą spinduliuojantis rytietiškas medienos ir muskuso kvapas.",
		                      129.99f));
		itemList.add(new Item("Tualetinis vanduo Calvin Klein CK IN2U Her EDT moterims 150 ml",
		                      "Seksualumą ir spontaniškumą žadinantys madingi Calvin Klein ckIN2U kvepalai moterims išreiškia jaunų žmonių laisvę ir galimybes tyrinėti pasaulį. Jaunatviškas ir seksualus jų aromatas slypi paprasto, bet patrauklaus minimalistinio dizaino flakone.\n" + "\n" + "Calvin Klein ckIN2U kvepalų moterims aromatas skleidžia gaivų gėlių ir rytietišką medienos kvapą. Iš pradžių užplūsta greipfrutų, bergamočių ir raudonųjų serbentų lapų kvapas, pereinantis į randenių ir baltažiedžių kaktusų aromatą. Galiausiai apgaubia ambros, kadagių ir vanilės dvelksmas.\n" + "\n" + "- Viršutinės natos: greipfrutai, bergamotės, raudonųjų serbentų lapai;\n" + "- Vidurinės natos: randenės, baltažiedžiai kaktusai;\n" + "- Pagrindinės natos: ambra, vanilė, kadagiai.",
		                      329.99f));
		itemList.add(new Item("Tualetinis vanduo Cerruti 1881 EDT moterims 100 ml",
		                      "Ryškus Cerruti 1881 kvepalų moterims aromatas – be galo elegantiškas. Supintas iš švelnaus gėlių bei žolelių, gryno jūros ir medienos kvapo.\n" + "\n" + "Pirmiausia pakvimpa mimozomis, bergamotėmis, žibuoklėmis ir frezijomis, po to užplūsta apelsinų žiedų, snapučių, jazminų ir dalbergijų aromatas. Galiausiai apgaubia medienos – santalų ir kedrų – bei ambros ir muskuso dvelksmas.\n" + "\n" + "Vaiskus Cerruti 1881 kvepalų moterims aromatas sužavės bet kokio amžiaus moterį – suteiks elegancijos ir primins prašmatnių baltinių prisilietimą bei odą glamonėjantį oro dvelksmą.\n" + "\n" + "- Viršutinės natos: mimozos, žibuoklės, frezijos, jazminai, pakalnutės, bergamotės, rožės;\n" + "- Vidurinės natos: kalendros, tuberozos, vilkdalgiai, ramunėlės, galbaninės ferulos, jazminai, juodosios dalbergijos, apelsinų žiedai, snapučiai, narcizai;\n" + "- Pagrindinės natos: santalai, ambra, muskusas, vanilė, kedrai.",
		                      9.99f));
		RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));
		adapter = new ItemListAdapter(itemList, this);
		recyclerView.setAdapter(adapter);
	}

	@Override public void onItemClick(Item item) {
		Intent intent = new Intent(this, ItemDetailsActivity.class);
		Bundle extras = new Bundle();
		extras.putString(ItemDetailsActivity.TITLE_KEY, item.name);
		extras.putString(ItemDetailsActivity.DESCRIPTION_KEY, item.description);
		extras.putFloat(ItemDetailsActivity.PRICE_KEY, item.price);
		intent.putExtras(extras);
		startActivity(intent);
	}

	@Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

	}

	@Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
		searchForItem(String.valueOf(charSequence));
	}

	@Override public void afterTextChanged(Editable editable) {

	}

	private void searchForItem(String query) {
		List<Item> searchedItems = new ArrayList<>();
		for (Item item : itemList) {
			if (item.name.toLowerCase()
			             .contains(query.toLowerCase())) {
				searchedItems.add(item);
			}
		}
		if (query.length() == 0) {
			adapter.setItems(itemList);
		} else {
			adapter.setItems(searchedItems);
		}
		adapter.notifyDataSetChanged();
	}
}
