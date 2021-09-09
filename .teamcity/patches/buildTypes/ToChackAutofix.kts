package patches.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.BuildType
import jetbrains.buildServer.configs.kotlin.v2019_2.buildFeatures.notifications
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2019_2.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, create a buildType with id = 'ToChackAutofix'
in the root project, and delete the patch script.
*/
create(DslContext.projectId, BuildType({
    id("ToChackAutofix")
    name = "To chack autofix"

    steps {
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
                echo "##teamcity[testStarted name='MyTest1.test1']"
                echo "##teamcity[testFinished name='MyTest1.test1']"
                
                echo "##teamcity[testStarted name='MyTest1.test1']"
                echo "##teamcity[testFailed name='MyTest1.test1' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest1.test1']"
                
                echo "##teamcity[testStarted name='MyTest1.test1']"
                echo "##teamcity[testFailed name='MyTest1.test1' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest1.test1']"
                
                echo "##teamcity[testStarted name='MyTest1.test1']"
                echo "##teamcity[testFailed name='MyTest1.test1' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest1.test1']"
                
                echo "##teamcity[testStarted name='MyTest1.test1']"
                echo "##teamcity[testFinished name='MyTest1.test1']"
                
                echo "##teamcity[testStarted name='MyTest1.test2']"
                echo "##teamcity[testFailed name='MyTest1.test2' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest1.test2']"
                
                echo "##teamcity[testStarted name='MyTest1.test2']"
                echo "##teamcity[testFinished name='MyTest1.test2']"
                
                echo "##teamcity[testStarted name='MyTest1.test3']"
                echo "##teamcity[testFailed name='MyTest1.test3' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest1.test3']"
                
                echo "##teamcity[testStarted name='MyTest1.test3']"
                echo "##teamcity[testFinished name='MyTest1.test3']"
                
                echo "##teamcity[testStarted name='MyTest1.test4']"
                echo "##teamcity[testFailed name='MyTest1.test4' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest1.test4']"
                
                echo "##teamcity[testStarted name='MyTest1.test4']"
                echo "##teamcity[testFinished name='MyTest1.test4']"
                
                echo "##teamcity[testStarted name='MyTest1.test5']"
                echo "##teamcity[testFailed name='MyTest1.test5' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest1.test5']"
                
                echo "##teamcity[testStarted name='MyTest1.test5']"
                echo "##teamcity[testFinished name='MyTest1.test5']"
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
                echo "##teamcity[testStarted name='MyTest1.XXX']"
                echo "##teamcity[testFinished name='MyTest1.XXX']"
                
                echo "##teamcity[testStarted name='MyTest1.test1']"
                echo "##teamcity[testFailed name='MyTest1.test1' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest1.test1']"
                
                
                echo "##teamcity[testStarted name='MyTest1.test5']"
                echo "##teamcity[testFailed name='MyTest1.test5' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest1.test5']"
            """.trimIndent()
        }
    }

    failureConditions {
        supportTestRetry = true
    }

    features {
        notifications {
            notifierSettings = emailNotifier {
                email = "inna_yan@mail.ru"
            }
            buildFailed = true
            firstBuildErrorOccurs = true
        }
    }
}))

