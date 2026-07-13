// 管理「Gradle 插件」的下载来源
pluginManagement {
    repositories {
        // 优先从 Google 仓库下载插件
        google {
            // 只允许从 Google 仓库下载这些前缀的插件（精准管控，避免下载到恶意插件）
            content {
                // 安卓官方插件（如 com.android.application）
                includeGroupByRegex("com\\.android.*")
                // Google 插件（如 com.google.gms.google-services）
                includeGroupByRegex("com\\.google.*")
                // AndroidX 相关插件
                includeGroupByRegex("androidx.*")
            }
        }
        // 其他插件从 Maven 中央仓库下载
        mavenCentral()
        // Gradle 官方插件仓库（比如 foojay-resolver-convention 这类 Gradle 官方插件）
        gradlePluginPortal()
    }
}

// 所有普通依赖
dependencyResolutionManagement {
    // 依赖仓库规则：优先用本文件的仓库配置，忽略模块级 build.gradle 中的仓库配置
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        /**
         * 第三方开源项目的 “便捷分发仓库”
         * 不在 Maven Central/Google 仓库里的开源项目（比如 GitHub 上的个人库、小众库）。
         * 例：某个 GitHub 上的自定义 View 库、工具类库，作者没上传到中央仓库，只提供了 JitPack 地址。
         */
        maven("https://jitpack.io")
        /**
         * 阿里云 “综合镜像仓库”
         * 几乎覆盖所有主流仓库的内容（是个 “大合集”）：
         * - 同步了 Maven Central（全球最大的中央仓库，大部分开源库在这里）
         * - 同步了 Google 仓库的大部分内容
         * - 同步了 Gradle 插件仓库的大部分内容
         */
        maven("https://maven.aliyun.com/repository/public")
        google()
        mavenCentral()
    }
}

rootProject.name = "material-android"
include(":app")