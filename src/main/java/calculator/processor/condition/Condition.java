package calculator.processor.condition;

import calculator.processor.condition.impl.HasInvalidChildCondition;
import calculator.processor.condition.impl.MoreThanOneChildCondition;
import calculator.processor.condition.impl.OneChildCondition;
import calculator.processor.condition.impl.RaisingAloneCondition;
import model.DataSet;

public abstract class Condition {

    public static Condition getCondition(DataSet data) {
        if (data.isRaisingAlone()) {
            return new RaisingAloneCondition();
        } else if (data.getChildrenAmount() > 1) {
            return new MoreThanOneChildCondition();
        } else if (data.getInvalidChildrenAmount() > 0) {
            return new HasInvalidChildCondition();
        } else {
            return new OneChildCondition();
        }
    }

    public abstract Integer getChildrenDeduction(DataSet data);
    public abstract Integer getDependentsDeduction(DataSet data);
}
