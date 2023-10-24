package player;


import category.Category;
import lombok.Builder;
import roll.Roll;

import java.util.*;

@Builder
public class Player {
    private final List<Category> categoryList = new ArrayList<>(List.of(Category.values()));
    private Map<Category, Integer> scores = new HashMap<>();

    public List<Category> getAvailableCategories() {
        return List.copyOf(categoryList);
    }

    public boolean isCategoryAvailable(Category category) {
        return categoryList.contains(category);
    }

    public void handleRoll(Category category, Roll roll) throws Exception {
        if (scores == null)
            scores = new HashMap<>();

        if (isCategoryAvailable(category)) {
            scores.put(category, category.compute(roll));
            categoryList.remove(category);
        } else throw new Exception(category + " is not available");
    }

    public Category retrieveBestCategory() {
        return scores == null ?
            null :
            Collections.max(scores.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public int retrieveBestScore() {
        return scores == null ?
            0 :
            Collections.max(scores.entrySet(), Map.Entry.comparingByValue()).getValue();
    }

    public int retrieveGlobalScore() {
        return scores.values().stream().mapToInt(Integer::intValue).sum();
    }
}
