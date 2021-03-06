package core.controller;

import cucumber.api.Scenario;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class CucumberController {

    private  String planId;
    private  String suiteId;
    private  String testId;

    public CucumberController(Scenario scenario) {
        List<String> tags = (List<String>) scenario.getSourceTagNames();
        for (int i = 0; i < tags.size(); i++) {
            String value = tags.get(i).toUpperCase();
            String env = System.getProperty("env").toUpperCase();
            if(value.contains(env+"_SUITE_ID") ){
                this.suiteId = tags.get(i).toUpperCase().replace("@"+env+"_SUITE_ID=","");
            }else if(value.contains("TEST_ID")){
                this.testId = tags.get(i).toUpperCase().replace("@TEST_ID=","");
            }else if(value.contains("PLAN_ID")){
                this.planId = tags.get(i).toUpperCase().replace("@PLAN_ID=","");
            }
        }
    }

    public static int getStatus(Scenario scenario){
        switch (scenario.getStatus()) {
            case PASSED:
                return 2;
            case FAILED:
                return 3;
            case PENDING:
                return 4;
            case SKIPPED:
                return 4;
            case UNDEFINED:
                return 1;
        }
        return 0;
    }

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public String getSuiteId() {
		return suiteId;
	}

	public void setSuiteId(String suiteId) {
		this.suiteId = suiteId;
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}
    
    
}
