package com.daProject.controller;

import com.daProject.manager.executable.DminService;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class DminHandler extends APIHandlerServlet.APIRequestHandler {

    public static final DminHandler instance = new DminHandler();

    public static DminHandler getInstance() {
        return instance;
    }

    @Override
    protected JSONStreamAware processRequest(HttpServletRequest request) throws Exception {

        DminService dmin = new DminService();
        JSONObject responseJSON = new JSONObject();
        String target = request.getParameter("requestCase");

        switch (target) {
            case "getAllUsers":
                Map<String, String> gotcha = dmin.getAllUsers();
                for (String key : gotcha.keySet()) {
                    responseJSON.put(key, gotcha.get(key));
                }
                break;
            case "destroyUser":
                dmin.destroyUser(Long.parseLong(request.getParameter("userIdTD")));
                return null;
            default:
                return null;
        }

        return responseJSON;
    }
}
