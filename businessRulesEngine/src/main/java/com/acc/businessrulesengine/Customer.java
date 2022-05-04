package com.acc.businessrulesengine;

 class Customer {

  businessRuleEngine.addAction(facts -> {
      var jobTitle = facts.getFacts("jobTitle");
      if("CEO".equals(jobTitle)) {
          var name = facts.getFact("name");
          Mailer.sendEmail("sales@company.com", "Revelant customer" + name);
      }
     });

  //EXEMPLOS DO CASO SWITCH
  businessRuleEngine.addAction(facts -> {
   var forecastedAmount = 0.0;
   var dealStage = Stage.valueOf(facts.getFact("stage"));
   var amount = Double.parseDouble(facts.getFact("amount"));
   if(dealStage == Stage.LEAD){
    forecastedAmount = amount * 0.2;
   }
   else if(dealStage == Stage.EVALUATING) {
    forecastedAmount = amount * 0.5
   }
   else if (dealStage == Stage.INTERESTED) {
    forecastedAmount = amount * 0.8;
   }
   else if (dealStage == Stage.CLOSED) {
    forecastedAmount = amount;
   }
   facts.addFact("forescastedAmount", String.valueOf(forecastedAmount));
  });

  //forma com switch
  switch (dealStage) {
     case LEAD:
      forecastedAmount = amount * 0.2;
      break;
   case EVALUATING:
    forecastedAmount = amount * 0.5;
    break;
   case INTERESTED:
    forecastedAmount = amount * 0.8;
   case CLOSED:
    forecastedAmount = amount;
    break;
  }

  //nova foram de implementar o switch desde do java 12
  var forecastedAmount = amount * switch(dealStage) {
   case LEAD -> 0.2;
   case EVALUATING -> 0.5;
   case INTERESTED -> 0.8;
   case CLOSED -> 1;
  }

  //uma das melhores formas
    businessRuleEngine.addAction(facts -> {
    var forecastedAmount = 0.0;
    var dealStage = Stage.valueOf(facts.getFact("stage"));
    var amount = Double.parseDouble(facts.getFact("amount"));
    var forecastedAmount = amount * switch(dealStage) {
     case LEAD -> 0.2;
     case EVALUATING -> 0.5;
     case INTERESTED -> 0.8;
     case CLOSED -> 1;
    }
    facts.addFact("forescastedAmount", String.valueOf(forecastedAmount));
   });
}


