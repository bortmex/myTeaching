#include <jni.h>
/ * Заголовок для класса HelloWorld * /

#ifndef _Included_HelloWorld
#define _Included_HelloWorld
#ifdef __cplusplus
extern "C" {
#endif
/ *
 * Класс: HelloWorld
 * Метод: displayHelloWorld
 * Подпись: () V
 * /
JNIEXPORT void JNICALL Java_HelloWorld_displayHelloWorld
  (JNIEnv *, проект);

#ifdef __cplusplus
}
#endif
#endif