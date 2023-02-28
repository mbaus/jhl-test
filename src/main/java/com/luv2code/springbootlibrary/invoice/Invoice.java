package com.luv2code.springbootlibrary.invoice;

import java.util.Collection;

public record Invoice(Collection<Line> lines) {}
