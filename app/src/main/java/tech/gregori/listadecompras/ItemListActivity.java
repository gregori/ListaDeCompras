package tech.gregori.listadecompras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ItemListActivity extends AppCompatActivity {
    public static final String EXTRA_ITEM_TO_ADD = "tech.gregori.listadecompras.new_item";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
    }

    public void insertItemToList(View view) { // botão é o parâmetro sendo passado - quem foi clicado
        // obtém o botão que foi pressionado
        Button pressedButton = (Button) view;
        String itemStr = pressedButton.getText().toString();
        // cria intent
        Intent intent = new Intent();
        // adiciona o valor do item
        intent.putExtra(EXTRA_ITEM_TO_ADD, itemStr);
        // devolve a resposta e finaliza a activity
        setResult(RESULT_OK, intent);
        finish();
    }
}