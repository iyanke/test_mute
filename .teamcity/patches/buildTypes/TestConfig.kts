package patches.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.ScriptBuildStep
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2019_2.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the buildType with id = 'TestConfig'
accordingly, and delete the patch script.
*/
changeBuildType(RelativeId("TestConfig")) {
    expectSteps {
        script {
            enabled = false
            executionMode = BuildStep.ExecutionMode.RUN_ON_FAILURE
            scriptContent = """
                echo "##teamcity[testSuiteStarted name='suiteName']"
                
                echo "##teamcity[testStarted name='MyTest.test2']"
                echo "##teamcity[testFailed name='MyTest.test2' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest.test2']"
                
                echo "##teamcity[testStarted name='MyTest.XXX']"
                echo "##teamcity[testFailed name='MyTest.XXX' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest.XXX']"
                
                
                echo "##teamcity[testSuiteFinished name='suiteName']"
            """.trimIndent()
        }
        script {
            scriptContent = """
                echo "##teamcity[testStarted name='MyTest.test1']"
                echo "##teamcity[testFinished name='MyTest.test1']"
                
                echo "##teamcity[testStarted name='MyTest.test1']"
                echo "##teamcity[testFailed name='MyTest.test1' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest.test1']"
                
                echo "##teamcity[testStarted name='MyTest.test1']"
                echo "##teamcity[testFailed name='MyTest.test1' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest.test1']"
                
                echo "##teamcity[testStarted name='MyTest.test1']"
                echo "##teamcity[testFailed name='MyTest.test1' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest.test1']"
                
                echo "##teamcity[testStarted name='MyTest.test1']"
                echo "##teamcity[testFinished name='MyTest.test1']"
                
                echo "##teamcity[testStarted name='MyTest.test2']"
                echo "##teamcity[testFailed name='MyTest.test2' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest.test2']"
                
                echo "##teamcity[testStarted name='MyTest.test2']"
                echo "##teamcity[testFinished name='MyTest.test2']"
                
                echo "##teamcity[testStarted name='MyTest.test3']"
                echo "##teamcity[testFailed name='MyTest.test3' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest.test3']"
                
                echo "##teamcity[testStarted name='MyTest.test3']"
                echo "##teamcity[testFinished name='MyTest.test3']"
                
                echo "##teamcity[testStarted name='MyTest.test4']"
                echo "##teamcity[testFailed name='MyTest.test4' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest.test4']"
                
                echo "##teamcity[testStarted name='MyTest.test4']"
                echo "##teamcity[testFinished name='MyTest.test4']"
                
                echo "##teamcity[testStarted name='MyTest.test5']"
                echo "##teamcity[testFailed name='MyTest.test5' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest.test5']"
                
                echo "##teamcity[testStarted name='MyTest.test5']"
                echo "##teamcity[testFinished name='MyTest.test5']"
            """.trimIndent()
        }
        script {
            name = "Wait"
            enabled = false
            executionMode = BuildStep.ExecutionMode.RUN_ON_FAILURE
            scriptContent = "ping 127.0.0.1 -n 60 > nul"
        }
        script {
            name = "New build step"
            enabled = false
            executionMode = BuildStep.ExecutionMode.RUN_ON_FAILURE
            scriptContent = """
                echo "##teamcity[testSuiteStarted name='suiteName']"
                
                echo "##teamcity[testStarted name='MyTest.test2']"
                
                
                echo "##teamcity[testFinished name='MyTest.test2']"
                
                
                
                echo "##teamcity[testSuiteFinished name='suiteName']"
            """.trimIndent()
        }
        script {
            name = "XXX"
            executionMode = BuildStep.ExecutionMode.RUN_ON_FAILURE
            scriptContent = """
                echo "##teamcity[testStarted name='MyTest.XXX']"
                echo "##teamcity[testFinished name='MyTest.XXX']"
                
                echo "##teamcity[testStarted name='MyTest.test1']"
                echo "##teamcity[testFailed name='MyTest.test1' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest.test1']"
                
                
                echo "##teamcity[testStarted name='MyTest.test5']"
                echo "##teamcity[testFailed name='MyTest.test5' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest.test5']"
            """.trimIndent()
        }
    }
    steps {
        update<ScriptBuildStep>(0) {
            clearConditions()
            scriptContent = """
                echo "##teamcity[testSuiteStarted name='suiteName1']"
                
                echo "##teamcity[testStarted name='MyTest.test1']"
                echo "##teamcity[testFailed name='MyTest.test1' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest.test1']"
                
                echo "##teamcity[testStarted name='MyTest.XXX1']"
                echo "##teamcity[testFailed name='MyTest.XXX1' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest.XXX1']"
                
                
                echo "##teamcity[testSuiteFinished name='suiteName1']"
                
                echo "##teamcity[testSuiteStarted name='suiteName2']"
                
                echo "##teamcity[testStarted name='MyTest.test2']"
                echo "##teamcity[testFailed name='MyTest.test2' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest.test2']"
                
                echo "##teamcity[testStarted name='MyTest.XXX2']"
                echo "##teamcity[testFailed name='MyTest.XXX2' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest.XXX2']"
                
                
                echo "##teamcity[testSuiteFinished name='suiteName2']"
                
                echo "##teamcity[testSuiteStarted name='suiteName3']"
                
                echo "##teamcity[testStarted name='MyTest.test3']"
                echo "##teamcity[testFailed name='MyTest.test3' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest.test3']"
                
                echo "##teamcity[testStarted name='MyTest.XXX3]"
                echo "##teamcity[testFailed name='MyTest.XXX3' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest.XXX3']"
                
                
                echo "##teamcity[testSuiteFinished name='suiteName3']"
            """.trimIndent()
        }
        update<ScriptBuildStep>(1) {
            enabled = false
            clearConditions()
        }
        update<ScriptBuildStep>(4) {
            enabled = false
            clearConditions()
        }
        insert(5) {
            script {
                name = "1"
                scriptContent = """
                    echo "##teamcity[testStarted name='MyTest.test1']"
                    echo "##teamcity[testFailed name='MyTest.test1' message='failure message' details='message and stack trace']"
                    echo "##teamcity[testFinished name='MyTest.test1']"
                    
                    echo "##teamcity[testStarted name='MyTest.test7']"
                    echo "##teamcity[testFailed name='MyTest.test7' message='failure message' details='message and stack trace']"
                    echo "##teamcity[testFinished name='MyTest.test7']"
                    
                    echo "##teamcity[testStarted name='MyTest.test8']"
                    echo "##teamcity[testFailed name='MyTest.test8' message='failure message' details='message and stack trace']"
                    echo "##teamcity[testFinished name='MyTest.test8']"
                    
                    echo "##teamcity[testStarted name='MyTest.test9']"
                    echo "##teamcity[testFailed name='MyTest.test9' message='failure message' details='message and stack trace']"
                    echo "##teamcity[testFinished name='MyTest.test9']"
                    
                    echo "##teamcity[testStarted name='MyTest.test6']"
                    echo "##teamcity[testFailed name='MyTest.test6' message='failure message' details='message and stack trace']"
                    echo "##teamcity[testFinished name='MyTest.test6']"
                    echo "##teamcity[testStarted name='MyTest.test5']"
                    echo "##teamcity[testFailed name='MyTest.test5' message='failure message' details='message and stack trace']"
                    echo "##teamcity[testFinished name='MyTest.test5']"
                    
                    echo "##teamcity[testStarted name='MyTest.test3']"
                    echo "##teamcity[testFailed name='MyTest.test3' message='failure message' details='message and stack trace']"
                    echo "##teamcity[testFinished name='MyTest.test3']"
                    
                    echo "##teamcity[testStarted name='MyTest.test4']"
                    echo "##teamcity[testFailed name='MyTest.test4' message='failure message' details='message and stack trace']"
                    echo "##teamcity[testFinished name='MyTest.test4']"
                """.trimIndent()
            }
        }
    }

    failureConditions {

        check(supportTestRetry == false) {
            "Unexpected option value: supportTestRetry = $supportTestRetry"
        }
        supportTestRetry = true
    }

    expectDisabledSettings()
    updateDisabledSettings("RUNNER_1")
}
