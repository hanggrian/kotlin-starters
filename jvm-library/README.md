[![bintray](https://img.shields.io/badge/bintray-maven-brightgreen.svg)](https://bintray.com/hendraanggrian/maven)
[![download](https://api.bintray.com/packages/hendraanggrian/maven/javapoet-ktx/images/download.svg)](https://bintray.com/hendraanggrian/maven/javapoet-ktx/_latestVersion)
[![build](https://travis-ci.com/hendraanggrian/javapoet-ktx.svg)](https://travis-ci.com/hendraanggrian/javapoet-ktx)
[![ktlint](https://img.shields.io/badge/code%20style-%E2%9D%A4-FF4081.svg)](https://ktlint.github.io/)

JavaPoet KTX
============
Lightweight Kotlin extension of [JavaPoet], providing Kotlin DSL functionality and other convenient solutions. 

 * Full of convenient methods to achieve minimum code writing possible.
 * Options to invoke DSL. For example, `methods.add("main") { ... }` is as good as `methods { "main" { ... } }`. Scroll down for more information.
 * Smooth transition, existing JavaPoet native specs can still be configured with DSL.

```kotlin
buildJavaFile("com.example.helloworld") {
    classType("HelloWorld") {
        modifiers = public + final
        methods {
            "main" {
                modifiers = public + static
                returns = void
                parameters.add<Array<String>>("args")
                appendln("%T.out.println(%S)", System::class, "Hello, JavaPoet!")
            }
        }
    }
}.writeTo(System.out)
```

Download
--------
```gradle
repositories {
    jcenter()
}

dependencies {
    implementation "com.hendraanggrian:javapoet-ktx:$version"
}
```

Usage
-----

#### Use `%` in string formatter
[JavaPoet] uses char prefix `$` when formatting literals (`$L`), strings (`$S`), types (`$T`), an names (`$N`) within strings.
However in Kotlin, `$` in strings is reserved for variable referral. Avoid using `\$` and instead use `%` as the prefix, this is also the approach taken by [KotlinPoet].

```kotlin
buildMethod("getName") {
    returns = TypeName.STRING
    appendln("%S", name)
}

buildCodeBlock {
    appendln("int result = 0")
    beginFlow("for (int i = %L; i < %L; i++)", 0, 10)
    appendln("result = result %L i", "+=")
    endFlow()
    appendln("return result")
}
```

#### Use `T::class` as parameters
`KClass<*>` can now be used as format arguments. There is also inline reified type function whenever possible.

```kotlin
buildMethod("sortList") {
    returns = TypeName.INT
    parameters.add(parameterizedTypeNameOf(classNameOf("java.util", "List"), hoverboard), "list")
    appendln("%T.sort(list)", Collections::class)
    appendln("return list")
}

buildField<Int>("count") {
    initializer("%L", 0)
}
```

#### Optional DSL
Some elements (field, method, parameter, etc.) are wrapped in container class. These containers have ability to add components with/without invoking DSL.

For example, 2 examples below will produce the same result.

```kotlin
addClass("Car") {
    annotations {
        SuppressWarnings::class {
            members {
                "value" {
                    add("deprecation")
                }
            }
        }
    }
    fields {
        "wheels"<Int> {
            initializer = "4"
        }
    }
    methods {
        "getWheels" {
            returns<Int>()
            statements {
                add("return wheels")
            }
        }
        "setWheels" {
            parameters {
                add(Int::class, "wheels")
            }
            statements {
                add("this.wheels = wheels")
            }
        }
    }
}

addClass("Car") {
    annotations.add<SuppressWarnings> {
        members.add("value", "deprecation")
    }
    fields.add<Int>("wheels") {
        initializer = "4"
    }
    methods.add("getWheels") {
        returns<Int>()
        statements.add("return wheels")
    }
    methods.add("setWheels") {
        parameters["wheels"] = Int::class
        statements.add("this.wheels = wheels")
    }
}
```

#### Type names extensions
Top-level creators of `TypeName` and all its subclasses.

```kotlin
val hoverboard = classNameOf("com.mattel", "Hoverboard")
val list = classNameOf("java.util", "List")
val listOfHoverboards = parameterizedTypeNameOf(list, hoverboard)
```

License
-------
    Copyright 2019 Hendra Anggrian

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

[JavaPoet]: https://github.com/square/javapoet
[KotlinPoet]: https://github.com/square/kotlinpoet