package org.http4k.hamkrest

import com.natpryce.hamkrest.Matcher
import com.natpryce.hamkrest.equalTo
import com.natpryce.hamkrest.has
import org.http4k.core.Body
import org.http4k.core.ContentType
import org.http4k.core.HttpMessage
import org.http4k.lens.BodyLens
import org.http4k.lens.Header
import org.http4k.lens.HeaderLens

fun <T> hasHeader(lens: HeaderLens<T>, matcher: Matcher<T>): Matcher<HttpMessage> = LensMatcher(has("Header '${lens.meta.name}'", { req: HttpMessage -> lens(req) }, matcher))

fun hasHeader(name: String, expected: String?): Matcher<HttpMessage> = has("Header '$name'", { m: HttpMessage -> m.header(name) }, equalTo(expected))

fun hasHeader(name: String, expected: List<String?>): Matcher<HttpMessage> = has("Header '$name'", { m: HttpMessage -> m.headerValues(name) }, equalTo(expected))

fun hasContentType(expected: ContentType): Matcher<HttpMessage> = has("Content-Type", { m: HttpMessage -> Header.Common.CONTENT_TYPE(m) }, equalTo(expected))

fun hasBody(expected: Matcher<Body>): Matcher<HttpMessage> = has("Body", { m: HttpMessage -> m.body }, expected)

@JvmName("hasBodyString")
fun hasBody(expected: Matcher<String>): Matcher<HttpMessage> = has("Body", { m: HttpMessage -> m.bodyString() }, expected)

fun hasBody(expected: String): Matcher<HttpMessage> = has("Body", { m: HttpMessage -> m.bodyString() }, equalTo(expected))

fun <T> hasBody(lens: BodyLens<T>, matcher: Matcher<T>): Matcher<HttpMessage> = LensMatcher(has("Body", { m: HttpMessage -> lens(m) }, matcher))
