package com.c.myParcel;

import java.util.Base64;
import java.util.Base64.*;

public interface Base64Coding {
	Encoder encoder = Base64.getEncoder();
	Decoder decoder = Base64.getDecoder();
}
