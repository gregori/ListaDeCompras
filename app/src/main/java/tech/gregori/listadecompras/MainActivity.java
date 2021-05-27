package tech.gregori.listadecompras;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/*
Crie um aplicativo de "lista de compras" simples, com uma "MainActivity" para a lista que o usuário
vai montar, e uma SecondActivity com uma lista de itens de compra comuns.

- A MainActivity deve conter a lista, que será composta de 10 (dez) elementos TextView vazios
- Um botão "Adicionar Item" na MainActivity abre a segunda activity que contém uma lista de itens de
 compra comuns (Queijo, Arroz, Feijão, Pão, etc). Use elementos "Button" para mostrar os itens.
- Escolher um item retorna o usuário à MainActivity e atualiza uma TextView vazia para incluir
 o item escolhido.

Use uma Intent para passar informação de uma ACtivity para a outra. Certifique-se de que o estado
atual da lista de compras é armazenado quando o usuário rotaciona o celular.
 */

public class MainActivity extends AppCompatActivity {
    public static final int TEXT_REQUEST = 1;
    private TextView[] displayItemList;
    private int listIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayItemList = new TextView[10];
        listIndex = 0;

        int displayCount = 0;
        displayItemList[displayCount++] = findViewById(R.id.display_item0);
        displayItemList[displayCount++] = findViewById(R.id.display_item1);
        displayItemList[displayCount++] = findViewById(R.id.display_item2);
        displayItemList[displayCount++] = findViewById(R.id.display_item3);
        displayItemList[displayCount++] = findViewById(R.id.display_item4);
        displayItemList[displayCount++] = findViewById(R.id.display_item5);
        displayItemList[displayCount++] = findViewById(R.id.display_item6);
        displayItemList[displayCount++] = findViewById(R.id.display_item7);
        displayItemList[displayCount++] = findViewById(R.id.display_item8);
        displayItemList[displayCount++] = findViewById(R.id.display_item9);
    }

    public void addItem(View view) {
        Intent intent = new Intent(this, ItemListActivity.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String chosenItem = data.getStringExtra(ItemListActivity.EXTRA_ITEM_TO_ADD);
                if (listIndex < 10) { // se ainda tem espaço na lista
                    displayItemList[listIndex].setText(chosenItem);
                    listIndex++;
                }

            }
        }
    }

}