package player;


import category.Category;
import lombok.Builder;
import lombok.Getter;
import roll.Roll;

import java.util.ArrayList;
import java.util.List;

@Builder
public class Player {
    private final List<Category> categoryList = new ArrayList<>(List.of(Category.values()));

    @Getter
    private int score = 0;

    public List<Category> getAvailableCategories() {
        return List.copyOf(categoryList);
    }

    public boolean isCategoryAvailable(Category category) {
        return categoryList.contains(category);
    }

    public void handleRoll(Category category, Roll roll) throws Exception {
        if (isCategoryAvailable(category)) {
            score += category.compute(roll);
            categoryList.remove(category);
        } else throw new Exception(category + " is not available");
    }
}
