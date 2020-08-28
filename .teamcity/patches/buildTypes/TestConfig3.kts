package patches.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2019_2.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the buildType with id = 'TestConfig3'
accordingly, and delete the patch script.
*/
changeBuildType(RelativeId("TestConfig3")) {
    expectSteps {
    }
    steps {
        insert(0) {
            script {
                scriptContent = """
                    echo "##teamcity[testStarted name='MyTest1.test6']"
                    echo "##teamcity[testFailed name='MyTest1.test6' message='failure message' details='message and stack trace']"
                    echo "##teamcity[testFinished name='MyTest1.test6']"
                    
                    echo "##teamcity[testStarted name='MyTest1.test6']"
                    echo "##teamcity[testFailed name='MyTest1.test6 message='failure message' details='message and stack trace']"
                    echo "##teamcity[testFinished name='MyTest1.test6]"
                    
                    echo "##teamcity[testStarted name='MyTest1.test6"
                    echo "##teamcity[testFailed name='MyTest1.test6' message='failure message' details='message and stack trace']"
                    echo "##teamcity[testFinished name='MyTest1.test6']"
                    
                    echo "##teamcity[testStarted name='MyTest1.test6']"
                    echo "##teamcity[testFinished name='MyTest1.test6']"
                    
                    echo "##teamcity[testStarted name='MyTest1.test6']"
                    echo "##teamcity[testFailed name='MyTest1.test6' message='failure message' details='message and stack trace']"
                    echo "##teamcity[testFinished name='MyTest1.test6']"
                    
                    echo "##teamcity[testStarted name='MyTest1.test7']"
                    echo "##teamcity[testFinished name='MyTest1.test7']"
                    
                    echo "##teamcity[testStarted name='MyTest1.test7']"
                    echo "##teamcity[testFailed name='MyTest1.test7' message='failure message' details='message and stack trace']"
                    echo "##teamcity[testFinished name='MyTest1.test7']"
                """.trimIndent()
            }
        }
    }

    failureConditions {

        check(javaCrash == false) {
            "Unexpected option value: javaCrash = $javaCrash"
        }
        javaCrash = true
    }
}
