package com.nimap.assesment.common;

import java.time.Instant;

public record ApiError(Instant timestamp, int status, String error, String path) { }
