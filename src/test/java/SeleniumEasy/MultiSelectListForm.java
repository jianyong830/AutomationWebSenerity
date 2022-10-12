package SeleniumEasy;

import java.util.List;

public class MultiSelectListForm extends SeleniumEasyForm {
    public List<String> selectedStatus() {
        return $("#multi-select").getSelectedValues();
    }

    public void selectStatus(String... states) {
        for(String state: states){
            $("#multi-select").select().byValue(state);
        }
    }
}
