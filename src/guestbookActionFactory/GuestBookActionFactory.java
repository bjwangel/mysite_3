package guestbookActionFactory;

import web.Action;
import web.ActionFactory;

public class GuestBookActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {

		Action action = null;

		if ("add".equals(actionName)) {
			action = new AddAction();
		} else if ("deleteform".equals(actionName)) {
			action = new DeleteFormAction();
		} else if ("delete".equals(actionName)) {
			action = new DeleteAction();
		} else if ("ajax".equals(actionName)) {
			action = new AjaxAction();
		}else if ("ajax-list".equals(actionName)) {
			action = new AjaxListAction();
		}else if ("ajax-add".equals(actionName)) {
			action = new AjaxListAddAction();
		} else {
			action = new ListAction();
		}

		return action;
	}

}
