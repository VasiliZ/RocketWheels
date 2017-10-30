package com.github.vasiliz.rocketswheel.json.parser;

import com.github.vasiliz.rocketswheel.json.parser.user.IUser;

import org.json.JSONException;

public interface IUserParser {

    IUser parse() throws JSONException;

}
