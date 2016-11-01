package userActionFactory;

import mainAction.MainAction;
import web.Action;
import web.ActionFactory;

public class UserActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;

		if ("joinform".equals(actionName)) {
			action = new JoinFormAction();
		} else if ("join".equals(actionName)) {
			action = new JoinAction();
		} else if ("loginform".equals(actionName)) {
			action = new LoginFormAction();
		} else if ("login".equals(actionName)) {
			action = new LoginAction();
		} else if ("joinsuccess".equals(actionName)) {
			action = new joinSuccessAction();
		} else if ("logout".equals(actionName)) {
			action = new LogoutAction();
		} else if ("modifyform".equals(actionName)) {
			action = new ModifyFormAction();
		} else if("checkemail".equals(actionName)){
			action=new CheckEmailAction();
		} else {
			action = new MainAction(); // 메인으로 돌아감
		}

		return action;
	}

}
