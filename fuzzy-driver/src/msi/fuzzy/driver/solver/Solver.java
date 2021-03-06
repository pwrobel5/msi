package msi.fuzzy.driver.solver;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class Solver {
    private final FIS fis;

    public Solver(String fclFileName) {
        this.fis = FIS.load(fclFileName);
    }

    public void drawCharts() {
        JFuzzyChart.get().chart(fis);
    }

    public Variable getAction(double distance, double weight, double loudness) {
        fis.setVariable("distance", distance);
        fis.setVariable("weight", weight);
        fis.setVariable("loudness", loudness);

        fis.evaluate();

        return fis.getVariable("action");
    }

    public void showActionChart(Variable action) {
        JFuzzyChart.get().chart(action, action.getDefuzzifier(), true);
    }
}
