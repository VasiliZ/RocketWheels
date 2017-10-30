package com.github.vasiliz.rocketswheel.json.parser;

import com.github.vasiliz.rocketswheel.json.parser.user.IUserList;

import org.json.JSONException;

public interface IuserListParser {

    IUserList parse() throws JSONException;

}
