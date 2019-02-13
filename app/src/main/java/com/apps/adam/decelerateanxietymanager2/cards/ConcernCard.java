package com.apps.adam.decelerateanxietymanager2.cards;

import java.util.ArrayList;
import java.util.List;

public class ConcernCard extends Card
{

    private List<String> solutions;

    //Class constructor
    public ConcernCard(String cardName)
    {
        this.setCardName(cardName);
        solutions = new ArrayList<>();
    }

    public List<String> getSolutions()
    {
        return solutions;
    }

    public void addSolution(String solution)
    {
        solutions.add(solution);
    }


    public void removeSolution(int index)
    {
        solutions.remove(index);
    }


}
