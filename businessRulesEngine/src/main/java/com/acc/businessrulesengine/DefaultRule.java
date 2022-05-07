package com.acc.businessrulesengine;

public class DefaultRule implements Rule {

    private final Condition condition;
    private final Action action;

    public Rule(final Condition condition, final Action action) {
        this.condition = condition;
        this.action = action;
    }

    public DefaultRule(Condition condition, Action action) {
        this.condition = condition;
        this.action = action;
    }

    public void perform(final Facts facts) {
        if (condition.evaluate(facts)) {
            action.execute(facts);
        }
    }

     final Condition condition = (Facts facts) -> "CEO".equals(facts.getFact("jobTitle"));
    final Action action = (Facts facts) -> {
        var name = facts.getFact("name");
        Mailer.sendEmail("sales@compay.com","Revelant custumer!!: " + name);
    };
    final Rule rule = new DefaultRule(condition, action);

}

