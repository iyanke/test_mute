package patches.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.BuildType
import jetbrains.buildServer.configs.kotlin.v2019_2.buildFeatures.notifications
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2019_2.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, create a buildType with id = 'RepeatedTestsInTheSameBuild'
in the root project, and delete the patch script.
*/
create(DslContext.projectId, BuildType({
    id("RepeatedTestsInTheSameBuild")
    name = "Repeated tests in the same build"

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
            enabled = false
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
            enabled = false
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
        script {
            name = "1"
            scriptContent = """
                echo "##teamcity[testStarted name='MyTest.test1']"
                echo "##teamcity[testFailed name='MyTest.test1' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest.test1']"
                
                echo "##teamcity[testStarted name='MyTest.test1']"
                echo "##teamcity[testFinished name='MyTest.test1']"
                
                echo "##teamcity[testStarted name='MyTest.test1']"
                echo "##teamcity[testFailed name='MyTest.test1' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest.test1']"
                
                echo "##teamcity[testStarted name='MyTest.test1']"
                echo "##teamcity[testFailed name='MyTest.test1' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest.test1']"
            """.trimIndent()
        }
    }

    features {
        notifications {
            enabled = false
            notifierSettings = emailNotifier {
                email = "inna_yan@mail.ru"
            }
            buildFailed = true
            firstBuildErrorOccurs = true
        }
    }
}))

