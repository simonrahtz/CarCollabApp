package com.test.sharecar.components

import android.content.Context
import android.location.Address
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.test.sharecar.CustomGeoCoder

/**
 * A custom layout that displays an OutlinedTextField for an address input. A list of suggestions
 * will be displayed in a LazyColumn when input text is over 10 characters, using the Android
 * CustomGeoCoder.getFromLocation method to return a list of Address objects based on the search query.
 *
 * If a user clicks a suggestion the LazyColumn List will be cleared and the TextField text will
 * be replaced by suggestion
 *
 * Note: CustomGeoCoder needs to be localised to the user's region
 *
 * Params: context - the context used for the CustomGeoCoder (use LocalContext.Current).
 *         searchQuery - the String containing the TextField input
 *         label - the label given to the OutLinedTextField
 */

@Composable
fun AddressSuggestionField(
    context: Context,
    searchQuery: String,
    label: String,
    onTextChange: (String) -> Unit
) {
    var searchQuery = searchQuery
    var addresses = mutableListOf<Address>()
    var listState: LazyListState = rememberLazyListState()
    var clicked by remember { mutableStateOf(false) }

    CustomTextField(title = label,
        textState = searchQuery,
        onTextChange = onTextChange,
        onClickCancel = {
            clicked = false
            searchQuery = ""
        })

    // Start Search for addresses when the input string is more than 10 characters
    if (searchQuery.length > 10) {
        addresses = CustomGeoCoder(context).getAddressFromString(searchQuery).toMutableList()
    }

    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        state = listState

    ) {

        //reset list when clicked
        if (clicked) addresses.clear()

        items(addresses) { address ->

            // Custom Address String - street number, street name and suburb
            var suggestion =
                address.subThoroughfare + " " + address.thoroughfare + " " + address.locality
            Box(
                modifier = Modifier
                    .padding(10.dp)
                    .clickable(onClick = {
                        searchQuery = suggestion
                        clicked = true

                    })
            ) {
                Text(text = suggestion)
            }
        }
    }

}