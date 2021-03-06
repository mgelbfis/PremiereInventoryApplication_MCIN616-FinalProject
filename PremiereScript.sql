USE [master]
GO
/****** Object:  Database [PREMIERE]    Script Date: 7/31/2017 11:00:16 AM ******/
CREATE DATABASE [PREMIERE]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'PREMIERE', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\PREMIERE.mdf' , SIZE = 3264KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'PREMIERE_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\PREMIERE_log.ldf' , SIZE = 816KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [PREMIERE] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [PREMIERE].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [PREMIERE] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [PREMIERE] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [PREMIERE] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [PREMIERE] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [PREMIERE] SET ARITHABORT OFF 
GO
ALTER DATABASE [PREMIERE] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [PREMIERE] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [PREMIERE] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [PREMIERE] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [PREMIERE] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [PREMIERE] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [PREMIERE] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [PREMIERE] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [PREMIERE] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [PREMIERE] SET  ENABLE_BROKER 
GO
ALTER DATABASE [PREMIERE] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [PREMIERE] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [PREMIERE] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [PREMIERE] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [PREMIERE] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [PREMIERE] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [PREMIERE] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [PREMIERE] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [PREMIERE] SET  MULTI_USER 
GO
ALTER DATABASE [PREMIERE] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [PREMIERE] SET DB_CHAINING OFF 
GO
ALTER DATABASE [PREMIERE] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [PREMIERE] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [PREMIERE] SET DELAYED_DURABILITY = DISABLED 
GO
/* For security reasons the login is created disabled and with a random password. */
/****** Object:  Login [valKai]    Script Date: 7/31/2017 11:00:16 AM ******/
CREATE LOGIN [valKai] WITH PASSWORD=N'ÌÚúÂ¹GXiæ®²Oþuk$ò¹øöK_¥ìÒ¾', DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english], CHECK_EXPIRATION=OFF, CHECK_POLICY=OFF
GO
ALTER LOGIN [valKai] DISABLE
GO
/* For security reasons the login is created disabled and with a random password. */
/****** Object:  Login [TestMid]    Script Date: 7/31/2017 11:00:16 AM ******/
CREATE LOGIN [TestMid] WITH PASSWORD=N'¨,ÑìÒ»ëÌÏì-É4åä^ÔMÞ''w©TÕbéV', DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english], CHECK_EXPIRATION=ON, CHECK_POLICY=ON
GO
ALTER LOGIN [TestMid] DISABLE
GO
/* For security reasons the login is created disabled and with a random password. */
/****** Object:  Login [StudyingMid]    Script Date: 7/31/2017 11:00:16 AM ******/
CREATE LOGIN [StudyingMid] WITH PASSWORD=N'}ÃnFÊnõF÷ÓNçg²Ôh%tõr*=Ù', DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english], CHECK_EXPIRATION=ON, CHECK_POLICY=ON
GO
ALTER LOGIN [StudyingMid] DISABLE
GO
/* For security reasons the login is created disabled and with a random password. */
/****** Object:  Login [richhull]    Script Date: 7/31/2017 11:00:16 AM ******/
CREATE LOGIN [richhull] WITH PASSWORD=N'
HØ&°À-cS¡åæBâ±´fP·¬¬¹âLc³â(', DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english], CHECK_EXPIRATION=OFF, CHECK_POLICY=OFF
GO
ALTER LOGIN [richhull] DISABLE
GO
/****** Object:  Login [NT SERVICE\Winmgmt]    Script Date: 7/31/2017 11:00:16 AM ******/
CREATE LOGIN [NT SERVICE\Winmgmt] FROM WINDOWS WITH DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english]
GO
/****** Object:  Login [NT SERVICE\SQLWriter]    Script Date: 7/31/2017 11:00:16 AM ******/
CREATE LOGIN [NT SERVICE\SQLWriter] FROM WINDOWS WITH DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english]
GO
/****** Object:  Login [NT SERVICE\ReportServer$SQLEXPRESS]    Script Date: 7/31/2017 11:00:16 AM ******/
CREATE LOGIN [NT SERVICE\ReportServer$SQLEXPRESS] FROM WINDOWS WITH DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english]
GO
/****** Object:  Login [NT Service\MSSQL$SQLEXPRESS]    Script Date: 7/31/2017 11:00:16 AM ******/
CREATE LOGIN [NT Service\MSSQL$SQLEXPRESS] FROM WINDOWS WITH DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english]
GO
/****** Object:  Login [NT AUTHORITY\SYSTEM]    Script Date: 7/31/2017 11:00:16 AM ******/
CREATE LOGIN [NT AUTHORITY\SYSTEM] FROM WINDOWS WITH DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english]
GO
/* For security reasons the login is created disabled and with a random password. */
/****** Object:  Login [nanMarks]    Script Date: 7/31/2017 11:00:16 AM ******/
CREATE LOGIN [nanMarks] WITH PASSWORD=N'Ïí<ßt®ö @OteJÝIèáWæ	$41wwÉÚ	', DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english], CHECK_EXPIRATION=OFF, CHECK_POLICY=OFF
GO
ALTER LOGIN [nanMarks] DISABLE
GO
/* For security reasons the login is created disabled and with a random password. */
/****** Object:  Login [markM]    Script Date: 7/31/2017 11:00:16 AM ******/
CREATE LOGIN [markM] WITH PASSWORD=N'ÓÈ&¥Ç÷F.ËYP¥y"ÅwR¡IBeåV¿D', DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english], CHECK_EXPIRATION=OFF, CHECK_POLICY=OFF
GO
ALTER LOGIN [markM] DISABLE
GO
/* For security reasons the login is created disabled and with a random password. */
/****** Object:  Login [lisaL]    Script Date: 7/31/2017 11:00:16 AM ******/
CREATE LOGIN [lisaL] WITH PASSWORD=N'p-)Påab©Ì¸ýHõ>(ÈD×joµ¯eÏU', DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english], CHECK_EXPIRATION=OFF, CHECK_POLICY=OFF
GO
ALTER LOGIN [lisaL] DISABLE
GO
/* For security reasons the login is created disabled and with a random password. */
/****** Object:  Login [LeeCust]    Script Date: 7/31/2017 11:00:16 AM ******/
CREATE LOGIN [LeeCust] WITH PASSWORD=N'{FâYÉ
ÆËwz÷H°iF\Êí%­¥', DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english], CHECK_EXPIRATION=OFF, CHECK_POLICY=OFF
GO
ALTER LOGIN [LeeCust] DISABLE
GO
/* For security reasons the login is created disabled and with a random password. */
/****** Object:  Login [KlineCust]    Script Date: 7/31/2017 11:00:16 AM ******/
CREATE LOGIN [KlineCust] WITH PASSWORD=N'¯5Køý0s0¾3&{ä¶W§r¿£', DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english], CHECK_EXPIRATION=OFF, CHECK_POLICY=OFF
GO
ALTER LOGIN [KlineCust] DISABLE
GO
/* For security reasons the login is created disabled and with a random password. */
/****** Object:  Login [juanP]    Script Date: 7/31/2017 11:00:16 AM ******/
CREATE LOGIN [juanP] WITH PASSWORD=N'ÈR~Y?²;yÎj¹z!ÒoKÇ''&£ù­ô×V', DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english], CHECK_EXPIRATION=OFF, CHECK_POLICY=OFF
GO
ALTER LOGIN [juanP] DISABLE
GO
/* For security reasons the login is created disabled and with a random password. */
/****** Object:  Login [JohnsonCust]    Script Date: 7/31/2017 11:00:16 AM ******/
CREATE LOGIN [JohnsonCust] WITH PASSWORD=N'CÝ¡É/ PÒ­
ÀÚ]{¿ÍþÝ''n¹', DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english], CHECK_EXPIRATION=OFF, CHECK_POLICY=OFF
GO
ALTER LOGIN [JohnsonCust] DISABLE
GO
/* For security reasons the login is created disabled and with a random password. */
/****** Object:  Login [harryH]    Script Date: 7/31/2017 11:00:16 AM ******/
CREATE LOGIN [harryH] WITH PASSWORD=N'/N°4)?àüKwÓ
>Í0¨r²DÍÙù', DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english], CHECK_EXPIRATION=OFF, CHECK_POLICY=OFF
GO
ALTER LOGIN [harryH] DISABLE
GO
/* For security reasons the login is created disabled and with a random password. */
/****** Object:  Login [guest]    Script Date: 7/31/2017 11:00:16 AM ******/
CREATE LOGIN [guest] WITH PASSWORD=N'/V·ñjìj£hPr}úÀ&¦5-gçé>7dü', DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english], CHECK_EXPIRATION=OFF, CHECK_POLICY=OFF
GO
ALTER LOGIN [guest] DISABLE
GO
/* For security reasons the login is created disabled and with a random password. */
/****** Object:  Login [garyG]    Script Date: 7/31/2017 11:00:16 AM ******/
CREATE LOGIN [garyG] WITH PASSWORD=N'¡§IYÐ_Û3x[FÇßÊM»FWÀn	Û', DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english], CHECK_EXPIRATION=OFF, CHECK_POLICY=OFF
GO
ALTER LOGIN [garyG] DISABLE
GO
/* For security reasons the login is created disabled and with a random password. */
/****** Object:  Login [frankF]    Script Date: 7/31/2017 11:00:16 AM ******/
CREATE LOGIN [frankF] WITH PASSWORD=N'Ó3Ó¸ÜÞ%î¸j7eÚ­ê­÷$¬¤nhð÷{q', DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english], CHECK_EXPIRATION=OFF, CHECK_POLICY=OFF
GO
ALTER LOGIN [frankF] DISABLE
GO
/* For security reasons the login is created disabled and with a random password. */
/****** Object:  Login [fergCust]    Script Date: 7/31/2017 11:00:16 AM ******/
CREATE LOGIN [fergCust] WITH PASSWORD=N'/©*G®`óï{§>uz´k`ÒÙaÅðUÅ', DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english], CHECK_EXPIRATION=OFF, CHECK_POLICY=OFF
GO
ALTER LOGIN [fergCust] DISABLE
GO
/* For security reasons the login is created disabled and with a random password. */
/****** Object:  Login [EveryCust]    Script Date: 7/31/2017 11:00:16 AM ******/
CREATE LOGIN [EveryCust] WITH PASSWORD=N'*gÍ¦´){Z¢÷LçÄÃ]ØSÜ?¹QÀ§º0', DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english], CHECK_EXPIRATION=OFF, CHECK_POLICY=OFF
GO
ALTER LOGIN [EveryCust] DISABLE
GO
/****** Object:  Login [DESKTOP-H3B32JA\mbg]    Script Date: 7/31/2017 11:00:16 AM ******/
CREATE LOGIN [DESKTOP-H3B32JA\mbg] FROM WINDOWS WITH DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english]
GO
/* For security reasons the login is created disabled and with a random password. */
/****** Object:  Login [DeerCust]    Script Date: 7/31/2017 11:00:16 AM ******/
CREATE LOGIN [DeerCust] WITH PASSWORD=N'(µ°¯Z¬²Z¶Êr4*m&¡Ú£ì_ZÙëþÿ', DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english], CHECK_EXPIRATION=OFF, CHECK_POLICY=OFF
GO
ALTER LOGIN [DeerCust] DISABLE
GO
/* For security reasons the login is created disabled and with a random password. */
/****** Object:  Login [davidC]    Script Date: 7/31/2017 11:00:16 AM ******/
CREATE LOGIN [davidC] WITH PASSWORD=N'ä!)5F¤ñ5Y¬â¿ î1ÿ{¡T¥{­xÝØE«', DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english], CHECK_EXPIRATION=OFF, CHECK_POLICY=OFF
GO
ALTER LOGIN [davidC] DISABLE
GO
/****** Object:  Login [BUILTIN\Users]    Script Date: 7/31/2017 11:00:16 AM ******/
CREATE LOGIN [BUILTIN\Users] FROM WINDOWS WITH DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english]
GO
/* For security reasons the login is created disabled and with a random password. */
/****** Object:  Login [BrooksCust]    Script Date: 7/31/2017 11:00:16 AM ******/
CREATE LOGIN [BrooksCust] WITH PASSWORD=N'²:ÏÞL-Æ±`úb¿nt8Í»', DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english], CHECK_EXPIRATION=OFF, CHECK_POLICY=OFF
GO
ALTER LOGIN [BrooksCust] DISABLE
GO
/* For security reasons the login is created disabled and with a random password. */
/****** Object:  Login [billD]    Script Date: 7/31/2017 11:00:16 AM ******/
CREATE LOGIN [billD] WITH PASSWORD=N'ÅeZÞÐ¸/ÝgxÇ0¡ßx@ ÐýéX', DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english], CHECK_EXPIRATION=OFF, CHECK_POLICY=OFF
GO
ALTER LOGIN [billD] DISABLE
GO
/* For security reasons the login is created disabled and with a random password. */
/****** Object:  Login [bettyG]    Script Date: 7/31/2017 11:00:16 AM ******/
CREATE LOGIN [bettyG] WITH PASSWORD=N'ÊO­·Fý¶#øøÊÛV´Wýv9ò=[ã', DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english], CHECK_EXPIRATION=OFF, CHECK_POLICY=OFF
GO
ALTER LOGIN [bettyG] DISABLE
GO
/* For security reasons the login is created disabled and with a random password. */
/****** Object:  Login [BargainCust]    Script Date: 7/31/2017 11:00:16 AM ******/
CREATE LOGIN [BargainCust] WITH PASSWORD=N'+pè2ê,NwãôôþÅM ¶ÙMÊþ\×c-ßìw', DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english], CHECK_EXPIRATION=OFF, CHECK_POLICY=OFF
GO
ALTER LOGIN [BargainCust] DISABLE
GO
/* For security reasons the login is created disabled and with a random password. */
/****** Object:  Login [AllSeasonCust]    Script Date: 7/31/2017 11:00:16 AM ******/
CREATE LOGIN [AllSeasonCust] WITH PASSWORD=N'ÌûÞSöRa-ß½(ÕìgÀ¡{Ékù4', DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english], CHECK_EXPIRATION=OFF, CHECK_POLICY=OFF
GO
ALTER LOGIN [AllSeasonCust] DISABLE
GO
/* For security reasons the login is created disabled and with a random password. */
/****** Object:  Login [AlCust]    Script Date: 7/31/2017 11:00:16 AM ******/
CREATE LOGIN [AlCust] WITH PASSWORD=N']õýÛ§Ë-ØÃ3,É?x9ÉbêßdÅÝ', DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english], CHECK_EXPIRATION=OFF, CHECK_POLICY=OFF
GO
ALTER LOGIN [AlCust] DISABLE
GO
/* For security reasons the login is created disabled and with a random password. */
/****** Object:  Login [##MS_PolicyTsqlExecutionLogin##]    Script Date: 7/31/2017 11:00:16 AM ******/
CREATE LOGIN [##MS_PolicyTsqlExecutionLogin##] WITH PASSWORD=N'ñL.ç!\Z^- #LéÉ}Ì-æJ(ÿç', DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english], CHECK_EXPIRATION=OFF, CHECK_POLICY=ON
GO
ALTER LOGIN [##MS_PolicyTsqlExecutionLogin##] DISABLE
GO
/* For security reasons the login is created disabled and with a random password. */
/****** Object:  Login [##MS_PolicyEventProcessingLogin##]    Script Date: 7/31/2017 11:00:16 AM ******/
CREATE LOGIN [##MS_PolicyEventProcessingLogin##] WITH PASSWORD=N'Æm~ä«BHrv´çÒiÒRø£pÉR×èL.', DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english], CHECK_EXPIRATION=OFF, CHECK_POLICY=ON
GO
ALTER LOGIN [##MS_PolicyEventProcessingLogin##] DISABLE
GO
ALTER SERVER ROLE [sysadmin] ADD MEMBER [NT SERVICE\Winmgmt]
GO
ALTER SERVER ROLE [sysadmin] ADD MEMBER [NT SERVICE\SQLWriter]
GO
ALTER SERVER ROLE [sysadmin] ADD MEMBER [NT Service\MSSQL$SQLEXPRESS]
GO
ALTER SERVER ROLE [sysadmin] ADD MEMBER [DESKTOP-H3B32JA\mbg]
GO
USE [PREMIERE]
GO
/****** Object:  User [valKaiUser]    Script Date: 7/31/2017 11:00:17 AM ******/
CREATE USER [valKaiUser] FOR LOGIN [valKai] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  User [richhullUser]    Script Date: 7/31/2017 11:00:17 AM ******/
CREATE USER [richhullUser] FOR LOGIN [richhull] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  User [nanMarksUser]    Script Date: 7/31/2017 11:00:17 AM ******/
CREATE USER [nanMarksUser] FOR LOGIN [nanMarks] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  User [markMUser]    Script Date: 7/31/2017 11:00:17 AM ******/
CREATE USER [markMUser] FOR LOGIN [markM] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  User [lisaLUser]    Script Date: 7/31/2017 11:00:17 AM ******/
CREATE USER [lisaLUser] FOR LOGIN [lisaL] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  User [LeeCustUser]    Script Date: 7/31/2017 11:00:17 AM ******/
CREATE USER [LeeCustUser] FOR LOGIN [LeeCust] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  User [KlineCustUser]    Script Date: 7/31/2017 11:00:17 AM ******/
CREATE USER [KlineCustUser] FOR LOGIN [KlineCust] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  User [juanPUser]    Script Date: 7/31/2017 11:00:17 AM ******/
CREATE USER [juanPUser] FOR LOGIN [juanP] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  User [JohnsonCustUser]    Script Date: 7/31/2017 11:00:17 AM ******/
CREATE USER [JohnsonCustUser] FOR LOGIN [JohnsonCust] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  User [harryHUser]    Script Date: 7/31/2017 11:00:17 AM ******/
CREATE USER [harryHUser] FOR LOGIN [harryH] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  User [guestUser]    Script Date: 7/31/2017 11:00:17 AM ******/
CREATE USER [guestUser] FOR LOGIN [guest] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  User [garyGUser]    Script Date: 7/31/2017 11:00:17 AM ******/
CREATE USER [garyGUser] FOR LOGIN [garyG] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  User [frankFUser]    Script Date: 7/31/2017 11:00:17 AM ******/
CREATE USER [frankFUser] FOR LOGIN [frankF] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  User [fergCustUser]    Script Date: 7/31/2017 11:00:17 AM ******/
CREATE USER [fergCustUser] FOR LOGIN [fergCust] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  User [EveryCustUser]    Script Date: 7/31/2017 11:00:17 AM ******/
CREATE USER [EveryCustUser] FOR LOGIN [EveryCust] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  User [DeerCustUser]    Script Date: 7/31/2017 11:00:17 AM ******/
CREATE USER [DeerCustUser] FOR LOGIN [DeerCust] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  User [davidCUser]    Script Date: 7/31/2017 11:00:17 AM ******/
CREATE USER [davidCUser] FOR LOGIN [davidC] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  User [BrooksCustUser]    Script Date: 7/31/2017 11:00:17 AM ******/
CREATE USER [BrooksCustUser] FOR LOGIN [BrooksCust] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  User [billDUser]    Script Date: 7/31/2017 11:00:17 AM ******/
CREATE USER [billDUser] FOR LOGIN [billD] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  User [bettyGUser]    Script Date: 7/31/2017 11:00:17 AM ******/
CREATE USER [bettyGUser] FOR LOGIN [bettyG] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  User [BargainCustUser]    Script Date: 7/31/2017 11:00:17 AM ******/
CREATE USER [BargainCustUser] FOR LOGIN [BargainCust] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  User [AllSeasonCustUser]    Script Date: 7/31/2017 11:00:17 AM ******/
CREATE USER [AllSeasonCustUser] FOR LOGIN [AllSeasonCust] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  User [AICustUser]    Script Date: 7/31/2017 11:00:17 AM ******/
CREATE USER [AICustUser] FOR LOGIN [AlCust] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  DatabaseRole [PR_WManagerRole]    Script Date: 7/31/2017 11:00:17 AM ******/
CREATE ROLE [PR_WManagerRole]
GO
/****** Object:  DatabaseRole [PR_SalesRole]    Script Date: 7/31/2017 11:00:17 AM ******/
CREATE ROLE [PR_SalesRole]
GO
/****** Object:  DatabaseRole [PR_PayrollRole]    Script Date: 7/31/2017 11:00:17 AM ******/
CREATE ROLE [PR_PayrollRole]
GO
/****** Object:  DatabaseRole [PR_OfficeRole]    Script Date: 7/31/2017 11:00:17 AM ******/
CREATE ROLE [PR_OfficeRole]
GO
/****** Object:  DatabaseRole [PR_EmployeeRole]    Script Date: 7/31/2017 11:00:17 AM ******/
CREATE ROLE [PR_EmployeeRole]
GO
/****** Object:  DatabaseRole [PR_CustomerRole]    Script Date: 7/31/2017 11:00:17 AM ******/
CREATE ROLE [PR_CustomerRole]
GO
/****** Object:  DatabaseRole [PR_BuyerRole]    Script Date: 7/31/2017 11:00:17 AM ******/
CREATE ROLE [PR_BuyerRole]
GO
/****** Object:  DatabaseRole [PR_AccountantRole]    Script Date: 7/31/2017 11:00:17 AM ******/
CREATE ROLE [PR_AccountantRole]
GO
ALTER ROLE [PR_EmployeeRole] ADD MEMBER [valKaiUser]
GO
ALTER ROLE [PR_SalesRole] ADD MEMBER [valKaiUser]
GO
ALTER ROLE [PR_EmployeeRole] ADD MEMBER [richhullUser]
GO
ALTER ROLE [PR_SalesRole] ADD MEMBER [richhullUser]
GO
ALTER ROLE [PR_EmployeeRole] ADD MEMBER [nanMarksUser]
GO
ALTER ROLE [PR_BuyerRole] ADD MEMBER [nanMarksUser]
GO
ALTER ROLE [PR_EmployeeRole] ADD MEMBER [markMUser]
GO
ALTER ROLE [PR_BuyerRole] ADD MEMBER [markMUser]
GO
ALTER ROLE [PR_EmployeeRole] ADD MEMBER [lisaLUser]
GO
ALTER ROLE [PR_BuyerRole] ADD MEMBER [lisaLUser]
GO
ALTER ROLE [PR_CustomerRole] ADD MEMBER [LeeCustUser]
GO
ALTER ROLE [PR_CustomerRole] ADD MEMBER [KlineCustUser]
GO
ALTER ROLE [PR_EmployeeRole] ADD MEMBER [juanPUser]
GO
ALTER ROLE [PR_SalesRole] ADD MEMBER [juanPUser]
GO
ALTER ROLE [PR_CustomerRole] ADD MEMBER [JohnsonCustUser]
GO
ALTER ROLE [PR_EmployeeRole] ADD MEMBER [harryHUser]
GO
ALTER ROLE [PR_WManagerRole] ADD MEMBER [harryHUser]
GO
ALTER ROLE [PR_EmployeeRole] ADD MEMBER [garyGUser]
GO
ALTER ROLE [PR_AccountantRole] ADD MEMBER [garyGUser]
GO
ALTER ROLE [PR_EmployeeRole] ADD MEMBER [frankFUser]
GO
ALTER ROLE [PR_WManagerRole] ADD MEMBER [frankFUser]
GO
ALTER ROLE [PR_CustomerRole] ADD MEMBER [fergCustUser]
GO
ALTER ROLE [PR_CustomerRole] ADD MEMBER [EveryCustUser]
GO
ALTER ROLE [PR_CustomerRole] ADD MEMBER [DeerCustUser]
GO
ALTER ROLE [PR_EmployeeRole] ADD MEMBER [davidCUser]
GO
ALTER ROLE [PR_PayrollRole] ADD MEMBER [davidCUser]
GO
ALTER ROLE [PR_CustomerRole] ADD MEMBER [BrooksCustUser]
GO
ALTER ROLE [PR_EmployeeRole] ADD MEMBER [billDUser]
GO
ALTER ROLE [PR_WManagerRole] ADD MEMBER [billDUser]
GO
ALTER ROLE [PR_EmployeeRole] ADD MEMBER [bettyGUser]
GO
ALTER ROLE [PR_OfficeRole] ADD MEMBER [bettyGUser]
GO
ALTER ROLE [PR_CustomerRole] ADD MEMBER [BargainCustUser]
GO
ALTER ROLE [PR_CustomerRole] ADD MEMBER [AllSeasonCustUser]
GO
ALTER ROLE [PR_CustomerRole] ADD MEMBER [AICustUser]
GO
ALTER ROLE [PR_EmployeeRole] ADD MEMBER [PR_WManagerRole]
GO
ALTER ROLE [PR_EmployeeRole] ADD MEMBER [PR_SalesRole]
GO
ALTER ROLE [PR_EmployeeRole] ADD MEMBER [PR_PayrollRole]
GO
ALTER ROLE [PR_EmployeeRole] ADD MEMBER [PR_OfficeRole]
GO
ALTER ROLE [PR_EmployeeRole] ADD MEMBER [PR_BuyerRole]
GO
ALTER ROLE [PR_EmployeeRole] ADD MEMBER [PR_AccountantRole]
GO
GRANT CONNECT TO [AICustUser] AS [dbo]
GO
GRANT CONNECT TO [AllSeasonCustUser] AS [dbo]
GO
GRANT CONNECT TO [BargainCustUser] AS [dbo]
GO
GRANT CONNECT TO [bettyGUser] AS [dbo]
GO
GRANT CONNECT TO [billDUser] AS [dbo]
GO
GRANT CONNECT TO [BrooksCustUser] AS [dbo]
GO
GRANT CONNECT TO [davidCUser] AS [dbo]
GO
GRANT CONNECT TO [DeerCustUser] AS [dbo]
GO
GRANT CONNECT TO [EveryCustUser] AS [dbo]
GO
GRANT CONNECT TO [fergCustUser] AS [dbo]
GO
GRANT CONNECT TO [frankFUser] AS [dbo]
GO
GRANT CONNECT TO [garyGUser] AS [dbo]
GO
GRANT CONNECT TO [guestUser] AS [dbo]
GO
GRANT CONNECT TO [harryHUser] AS [dbo]
GO
GRANT CONNECT TO [JohnsonCustUser] AS [dbo]
GO
GRANT CONNECT TO [juanPUser] AS [dbo]
GO
GRANT CONNECT TO [KlineCustUser] AS [dbo]
GO
GRANT CONNECT TO [LeeCustUser] AS [dbo]
GO
GRANT CONNECT TO [lisaLUser] AS [dbo]
GO
GRANT CONNECT TO [markMUser] AS [dbo]
GO
GRANT CONNECT TO [nanMarksUser] AS [dbo]
GO
GRANT CONNECT TO [richhullUser] AS [dbo]
GO
GRANT CONNECT TO [valKaiUser] AS [dbo]
GO
/****** Object:  Table [dbo].[CUSTOMER]    Script Date: 7/31/2017 11:00:18 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[CUSTOMER](
	[CUST_NUM] [int] NOT NULL,
	[CUST_NAME] [varchar](40) NOT NULL,
	[CUST_STREET] [varchar](30) NOT NULL,
	[CUST_CITY] [varchar](25) NOT NULL,
	[CUST_STATE] [char](2) NOT NULL,
	[CUST_ZIP] [nchar](9) NOT NULL,
	[CUST_BALANCE] [smallmoney] NOT NULL,
	[CREDIT_LIMIT] [decimal](7, 2) NOT NULL,
	[REP_NUM] [int] NOT NULL,
	[PHONE] [char](10) NOT NULL,
	[BEGIN_DATE]  AS (getdate()),
	[Cust_Login] [sysname] NULL,
 CONSTRAINT [PK_CUSTOMER] PRIMARY KEY CLUSTERED 
(
	[CUST_NUM] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [UIX_CustPhone] UNIQUE NONCLUSTERED 
(
	[PHONE] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
GRANT SELECT ON [dbo].[CUSTOMER] TO [PR_AccountantRole] AS [dbo]
GO
GRANT INSERT ON [dbo].[CUSTOMER] TO [PR_OfficeRole] AS [dbo]
GO
GRANT SELECT ON [dbo].[CUSTOMER] TO [PR_OfficeRole] AS [dbo]
GO
GRANT UPDATE ON [dbo].[CUSTOMER] TO [PR_OfficeRole] AS [dbo]
GO
GRANT UPDATE ON [dbo].[CUSTOMER] ([CREDIT_LIMIT]) TO [PR_AccountantRole] AS [dbo]
GO
GRANT UPDATE ON [dbo].[CUSTOMER] ([REP_NUM]) TO [PR_AccountantRole] AS [dbo]
GO
/****** Object:  Table [dbo].[EMPLOYEE]    Script Date: 7/31/2017 11:00:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[EMPLOYEE](
	[EmpID] [int] NOT NULL,
	[FirstName] [varchar](20) NOT NULL,
	[LastName] [varchar](40) NOT NULL,
	[Street] [varchar](35) NOT NULL,
	[City] [varchar](25) NOT NULL,
	[EmpState] [char](2) NOT NULL,
	[ZipCode] [char](9) NULL,
	[PhoneNumber] [char](10) NOT NULL,
	[BirthDate] [date] NOT NULL,
	[HireDate] [date] NOT NULL,
	[EmpTypeID] [int] NOT NULL,
	[EmpLogin] [sysname] NULL,
 CONSTRAINT [PK_Employee] PRIMARY KEY CLUSTERED 
(
	[EmpID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [UIX_PhoneNumber] UNIQUE NONCLUSTERED 
(
	[PhoneNumber] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
GRANT INSERT ON [dbo].[EMPLOYEE] TO [PR_AccountantRole] AS [dbo]
GO
GRANT SELECT ON [dbo].[EMPLOYEE] TO [PR_AccountantRole] AS [dbo]
GO
GRANT INSERT ON [dbo].[EMPLOYEE] TO [PR_OfficeRole] AS [dbo]
GO
GRANT UPDATE ON [dbo].[EMPLOYEE] TO [PR_OfficeRole] AS [dbo]
GO
GRANT SELECT ON [dbo].[EMPLOYEE] ([EmpID]) TO [PR_OfficeRole] AS [dbo]
GO
GRANT SELECT ON [dbo].[EMPLOYEE] ([FirstName]) TO [PR_OfficeRole] AS [dbo]
GO
GRANT SELECT ON [dbo].[EMPLOYEE] ([LastName]) TO [PR_OfficeRole] AS [dbo]
GO
GRANT SELECT ON [dbo].[EMPLOYEE] ([Street]) TO [PR_OfficeRole] AS [dbo]
GO
GRANT SELECT ON [dbo].[EMPLOYEE] ([City]) TO [PR_OfficeRole] AS [dbo]
GO
GRANT SELECT ON [dbo].[EMPLOYEE] ([EmpState]) TO [PR_OfficeRole] AS [dbo]
GO
GRANT SELECT ON [dbo].[EMPLOYEE] ([ZipCode]) TO [PR_OfficeRole] AS [dbo]
GO
GRANT SELECT ON [dbo].[EMPLOYEE] ([PhoneNumber]) TO [PR_OfficeRole] AS [dbo]
GO
/****** Object:  Table [dbo].[EmpType]    Script Date: 7/31/2017 11:00:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[EmpType](
	[EmpTypeID] [int] NOT NULL,
	[EmpTypeDesc] [varchar](40) NOT NULL,
 CONSTRAINT [PK_EmpType] PRIMARY KEY CLUSTERED 
(
	[EmpTypeID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ORDER_LINE]    Script Date: 7/31/2017 11:00:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ORDER_LINE](
	[ORDER_NUM] [int] NOT NULL,
	[PART_NUM] [nchar](10) NOT NULL,
	[QTY_ORDERED] [smallint] NOT NULL,
	[QUOTED_PRICE] [smallmoney] NOT NULL,
	[Subtotal]  AS ([qty_ordered]*[quoted_price]),
	[Modified_Date] [date] NOT NULL,
 CONSTRAINT [PK_ORDER_LINE] PRIMARY KEY CLUSTERED 
(
	[ORDER_NUM] ASC,
	[PART_NUM] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ORDERS]    Script Date: 7/31/2017 11:00:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ORDERS](
	[ORDER_NUM] [int] NOT NULL,
	[ORDER_DATE] [date] NOT NULL,
	[CUST_NUM] [int] NOT NULL,
 CONSTRAINT [PK_ORDER] PRIMARY KEY CLUSTERED 
(
	[ORDER_NUM] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PART]    Script Date: 7/31/2017 11:00:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PART](
	[PART_NUM] [nchar](10) NOT NULL,
	[PART_DESCRIPTION] [varchar](30) NOT NULL,
	[UNITS_ON_HAND] [smallint] NOT NULL,
	[CATEGORY] [nchar](2) NOT NULL,
	[WAREHOUSEID] [smallint] NOT NULL,
	[PRICE] [smallmoney] NOT NULL,
 CONSTRAINT [PK_Part] PRIMARY KEY CLUSTERED 
(
	[PART_NUM] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
GRANT INSERT ON [dbo].[PART] TO [PR_BuyerRole] AS [dbo]
GO
GRANT SELECT ON [dbo].[PART] TO [PR_BuyerRole] AS [dbo]
GO
GRANT SELECT ON [dbo].[PART] TO [PR_WManagerRole] AS [dbo]
GO
GRANT UPDATE ON [dbo].[PART] ([PRICE]) TO [PR_AccountantRole] AS [dbo]
GO
/****** Object:  Table [dbo].[PURCHASE]    Script Date: 7/31/2017 11:00:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PURCHASE](
	[PurchaseID] [int] NOT NULL,
	[Part_Num] [nchar](10) NOT NULL,
	[Emp_Num] [int] NOT NULL,
	[QtyPurchased] [int] NOT NULL,
	[UnitPricePaid] [smallmoney] NOT NULL,
	[DatePurchased] [date] NOT NULL,
	[DateReceived] [date] NULL,
	[QtyReceived] [int] NULL,
	[ReceivedBy] [int] NULL,
	[WarehouseID] [smallint] NULL,
 CONSTRAINT [PK_Purchase] PRIMARY KEY CLUSTERED 
(
	[PurchaseID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
GRANT INSERT ON [dbo].[PURCHASE] TO [PR_BuyerRole] AS [dbo]
GO
GRANT SELECT ON [dbo].[PURCHASE] TO [PR_BuyerRole] AS [dbo]
GO
DENY UPDATE ON [dbo].[PURCHASE] ([DateReceived]) TO [PR_BuyerRole] AS [dbo]
GO
GRANT UPDATE ON [dbo].[PURCHASE] ([DateReceived]) TO [PR_WManagerRole] AS [dbo]
GO
DENY UPDATE ON [dbo].[PURCHASE] ([QtyReceived]) TO [PR_BuyerRole] AS [dbo]
GO
GRANT UPDATE ON [dbo].[PURCHASE] ([QtyReceived]) TO [PR_WManagerRole] AS [dbo]
GO
DENY UPDATE ON [dbo].[PURCHASE] ([ReceivedBy]) TO [PR_BuyerRole] AS [dbo]
GO
GRANT UPDATE ON [dbo].[PURCHASE] ([ReceivedBy]) TO [PR_WManagerRole] AS [dbo]
GO
DENY UPDATE ON [dbo].[PURCHASE] ([WarehouseID]) TO [PR_BuyerRole] AS [dbo]
GO
GRANT UPDATE ON [dbo].[PURCHASE] ([WarehouseID]) TO [PR_WManagerRole] AS [dbo]
GO
/****** Object:  Table [dbo].[SALESREP]    Script Date: 7/31/2017 11:00:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SALESREP](
	[REP_NUM] [int] NOT NULL,
	[COMMISSION] [smallmoney] NOT NULL,
	[RATE] [decimal](3, 2) NOT NULL,
 CONSTRAINT [PK_SALESREP] PRIMARY KEY CLUSTERED 
(
	[REP_NUM] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
GRANT INSERT ON [dbo].[SALESREP] TO [PR_AccountantRole] AS [dbo]
GO
GRANT SELECT ON [dbo].[SALESREP] TO [PR_AccountantRole] AS [dbo]
GO
GRANT UPDATE ON [dbo].[SALESREP] ([RATE]) TO [PR_AccountantRole] AS [dbo]
GO
/****** Object:  Table [dbo].[WAREHOUSE]    Script Date: 7/31/2017 11:00:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[WAREHOUSE](
	[WarehouseID] [smallint] NOT NULL,
	[Street] [varchar](35) NOT NULL,
	[City] [varchar](35) NOT NULL,
	[WarehouseState] [char](2) NOT NULL,
	[ZipCode] [char](9) NULL,
	[PhoneNumber] [char](10) NOT NULL,
	[ManagerID] [int] NOT NULL,
 CONSTRAINT [PK_Warehouse] PRIMARY KEY CLUSTERED 
(
	[WarehouseID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [UIX_Warehouse_Manager] UNIQUE NONCLUSTERED 
(
	[WarehouseID] ASC,
	[ManagerID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  View [dbo].[CustomerData]    Script Date: 7/31/2017 11:00:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


create view [dbo].[CustomerData]
as
  select * from Customer
  where (Cust_Login = SUSER_SNAME()
        and is_member('PR_CustomerRole')=1)

GO
GRANT SELECT ON [dbo].[CustomerData] TO [PR_CustomerRole] AS [dbo]
GO
/****** Object:  View [dbo].[CustomerOrderData]    Script Date: 7/31/2017 11:00:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create view [dbo].[CustomerOrderData]
as
	select Orders.CUST_NUM, Order_Line.ORDER_NUM, Orders.ORDER_DATE, Order_Line.PART_NUM, order_line.QTY_ORDERED, 
	order_line.QUOTED_PRICE, ORDER_LINE.Subtotal, order_line.Modified_Date from ORDER_LINE 
	inner join ORDERS 
	on Order_line.ORDER_NUM = orders.ORDER_NUM
		inner join CUSTOMER
		on orders.CUST_NUM = CUSTOMER.CUST_NUM
		where (Customer.cust_login = SUSER_NAME() and IS_MEMBER('PR_CustomerRole')=1)

GO
GRANT SELECT ON [dbo].[CustomerOrderData] TO [PR_CustomerRole] AS [dbo]
GO
/****** Object:  View [dbo].[EmployeeData]    Script Date: 7/31/2017 11:00:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO



CREATE VIEW [dbo].[EmployeeData]
AS
  select EmpID ,FirstName ,  LastName,
   Street ,   City ,   EmpState ,
   ZipCode ,   PhoneNumber ,
   BirthDate ,   HireDate ,
   EmpTypeID 
   from employee 
       where 
        ( EmpLogin = SUSER_SNAME() and
		 is_member ('PR_EmployeeRole') = 1)
    

GO
GRANT SELECT ON [dbo].[EmployeeData] TO [PR_EmployeeRole] AS [dbo]
GO
GRANT UPDATE ON [dbo].[EmployeeData] ([Street]) TO [PR_EmployeeRole] AS [dbo]
GO
GRANT UPDATE ON [dbo].[EmployeeData] ([City]) TO [PR_EmployeeRole] AS [dbo]
GO
GRANT UPDATE ON [dbo].[EmployeeData] ([EmpState]) TO [PR_EmployeeRole] AS [dbo]
GO
GRANT UPDATE ON [dbo].[EmployeeData] ([ZipCode]) TO [PR_EmployeeRole] AS [dbo]
GO
GRANT UPDATE ON [dbo].[EmployeeData] ([PhoneNumber]) TO [PR_EmployeeRole] AS [dbo]
GO
/****** Object:  View [dbo].[EmpTypeData]    Script Date: 7/31/2017 11:00:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create view [dbo].[EmpTypeData]
as 
	select * from EmpType

GO
GRANT SELECT ON [dbo].[EmpTypeData] TO [PR_AccountantRole] AS [dbo]
GO
GRANT SELECT ON [dbo].[EmpTypeData] TO [PR_OfficeRole] AS [dbo]
GO
/****** Object:  View [dbo].[GuestView]    Script Date: 7/31/2017 11:00:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create view [dbo].[GuestView]
as
	select PART_DESCRIPTION, CATEGORY, PRICE from PART
		where units_on_hand != 0--available products

GO
GRANT SELECT ON [dbo].[GuestView] TO [guestUser] AS [dbo]
GO
/****** Object:  View [dbo].[SalesRepJustOrderData]    Script Date: 7/31/2017 11:00:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create view [dbo].[SalesRepJustOrderData] 
as
	select Orders.ORDER_NUM, Orders.ORDER_DATE, Orders.CUST_NUM from orders
	inner join CUSTOMER on ORDERS.CUST_NUM = CUSTOMER.CUST_NUM
		inner join SALESREP on CUSTOMER.REP_NUM = SALESREP.REP_NUM
			inner join EMPLOYEE on SALESREP.REP_NUM = EMPLOYEE.EmpID
			where EmpLogin = SUSER_NAME() and (IS_MEMBER('PR_SalesRole') = 1)

GO
GRANT INSERT ON [dbo].[SalesRepJustOrderData] TO [PR_SalesRole] AS [dbo]
GO
/****** Object:  View [dbo].[SalesRepJustOrderLineData]    Script Date: 7/31/2017 11:00:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create view [dbo].[SalesRepJustOrderLineData]
as 
	select ORDER_LINE.ORDER_NUM, ORDER_LINE.PART_NUM, ORDER_LINE.QTY_ORDERED, ORDER_LINE.QUOTED_PRICE, ORDER_LINE.Subtotal, ORDER_LINE.Modified_Date from ORDER_LINE
	inner join ORDERS on ORDER_LINE.ORDER_NUM = ORDERS.ORDER_NUM
	inner join CUSTOMER on ORDERS.CUST_NUM = CUSTOMER.CUST_NUM
		inner join SALESREP on CUSTOMER.REP_NUM = SALESREP.REP_NUM
			inner join EMPLOYEE on SALESREP.REP_NUM = EMPLOYEE.EmpID
			where EmpLogin = SUSER_NAME() and (IS_MEMBER('PR_SalesRole') = 1)

GO
GRANT INSERT ON [dbo].[SalesRepJustOrderLineData] TO [PR_SalesRole] AS [dbo]
GO
/****** Object:  View [dbo].[SalesRepNumbers]    Script Date: 7/31/2017 11:00:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create view [dbo].[SalesRepNumbers]
as
	select Rep_Num from SalesRep

GO
GRANT SELECT ON [dbo].[SalesRepNumbers] TO [PR_OfficeRole] AS [dbo]
GO
/****** Object:  View [dbo].[SalesRepOrderData]    Script Date: 7/31/2017 11:00:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE view [dbo].[SalesRepOrderData]
as 
select Orders.CUST_NUM, Order_Line.ORDER_NUM, Orders.ORDER_DATE, Order_Line.PART_NUM, order_line.QTY_ORDERED, 
	order_line.QUOTED_PRICE, ORDER_LINE.Subtotal, order_line.Modified_Date from ORDER_LINE 
	inner join ORDERS 
	on Order_line.ORDER_NUM = orders.ORDER_NUM 
	inner join Customer on orders.CUST_NUM = customer.CUST_NUM
		inner join salesrep on customer.REP_NUM = salesrep.REP_NUM
			inner join employee on salesrep.REP_NUM = employee.EmpID
			where (employee.EmpLogin = SUSER_NAME() and IS_MEMBER('PR_SalesRole')=1)

GO
GRANT DELETE ON [dbo].[SalesRepOrderData] TO [PR_SalesRole] AS [dbo]
GO
GRANT INSERT ON [dbo].[SalesRepOrderData] TO [PR_SalesRole] AS [dbo]
GO
GRANT SELECT ON [dbo].[SalesRepOrderData] TO [PR_SalesRole] AS [dbo]
GO
GRANT UPDATE ON [dbo].[SalesRepOrderData] TO [PR_SalesRole] AS [dbo]
GO
ALTER TABLE [dbo].[CUSTOMER]  WITH CHECK ADD  CONSTRAINT [FK_CUSTOMER_SALESREP] FOREIGN KEY([REP_NUM])
REFERENCES [dbo].[SALESREP] ([REP_NUM])
GO
ALTER TABLE [dbo].[CUSTOMER] CHECK CONSTRAINT [FK_CUSTOMER_SALESREP]
GO
ALTER TABLE [dbo].[EMPLOYEE]  WITH CHECK ADD  CONSTRAINT [FK_Emp_EmpType] FOREIGN KEY([EmpTypeID])
REFERENCES [dbo].[EmpType] ([EmpTypeID])
GO
ALTER TABLE [dbo].[EMPLOYEE] CHECK CONSTRAINT [FK_Emp_EmpType]
GO
ALTER TABLE [dbo].[ORDER_LINE]  WITH CHECK ADD  CONSTRAINT [FK_ORder_LINE_ORDERS] FOREIGN KEY([ORDER_NUM])
REFERENCES [dbo].[ORDERS] ([ORDER_NUM])
GO
ALTER TABLE [dbo].[ORDER_LINE] CHECK CONSTRAINT [FK_ORder_LINE_ORDERS]
GO
ALTER TABLE [dbo].[ORDER_LINE]  WITH CHECK ADD  CONSTRAINT [FK_Order_LINE_PART] FOREIGN KEY([PART_NUM])
REFERENCES [dbo].[PART] ([PART_NUM])
GO
ALTER TABLE [dbo].[ORDER_LINE] CHECK CONSTRAINT [FK_Order_LINE_PART]
GO
ALTER TABLE [dbo].[ORDERS]  WITH CHECK ADD  CONSTRAINT [FK_ORDERS_CUSTOMER] FOREIGN KEY([CUST_NUM])
REFERENCES [dbo].[CUSTOMER] ([CUST_NUM])
GO
ALTER TABLE [dbo].[ORDERS] CHECK CONSTRAINT [FK_ORDERS_CUSTOMER]
GO
ALTER TABLE [dbo].[PART]  WITH CHECK ADD  CONSTRAINT [FK_PART_WAREHOUSE] FOREIGN KEY([WAREHOUSEID])
REFERENCES [dbo].[WAREHOUSE] ([WarehouseID])
GO
ALTER TABLE [dbo].[PART] CHECK CONSTRAINT [FK_PART_WAREHOUSE]
GO
ALTER TABLE [dbo].[PURCHASE]  WITH CHECK ADD  CONSTRAINT [FK_Purchase_Employee] FOREIGN KEY([Emp_Num])
REFERENCES [dbo].[EMPLOYEE] ([EmpID])
GO
ALTER TABLE [dbo].[PURCHASE] CHECK CONSTRAINT [FK_Purchase_Employee]
GO
ALTER TABLE [dbo].[PURCHASE]  WITH CHECK ADD  CONSTRAINT [FK_Purchase_Part] FOREIGN KEY([Part_Num])
REFERENCES [dbo].[PART] ([PART_NUM])
GO
ALTER TABLE [dbo].[PURCHASE] CHECK CONSTRAINT [FK_Purchase_Part]
GO
ALTER TABLE [dbo].[PURCHASE]  WITH CHECK ADD  CONSTRAINT [FK_Purchase_Warehouse] FOREIGN KEY([WarehouseID], [ReceivedBy])
REFERENCES [dbo].[WAREHOUSE] ([WarehouseID], [ManagerID])
GO
ALTER TABLE [dbo].[PURCHASE] CHECK CONSTRAINT [FK_Purchase_Warehouse]
GO
ALTER TABLE [dbo].[SALESREP]  WITH CHECK ADD  CONSTRAINT [FK_SALESREP_EMPLOYEE] FOREIGN KEY([REP_NUM])
REFERENCES [dbo].[EMPLOYEE] ([EmpID])
GO
ALTER TABLE [dbo].[SALESREP] CHECK CONSTRAINT [FK_SALESREP_EMPLOYEE]
GO
ALTER TABLE [dbo].[WAREHOUSE]  WITH CHECK ADD  CONSTRAINT [FK_Warehouse_Emp] FOREIGN KEY([ManagerID])
REFERENCES [dbo].[EMPLOYEE] ([EmpID])
GO
ALTER TABLE [dbo].[WAREHOUSE] CHECK CONSTRAINT [FK_Warehouse_Emp]
GO
ALTER TABLE [dbo].[PURCHASE]  WITH CHECK ADD  CONSTRAINT [CHK_DateReceived] CHECK  (([DateReceived]>[DatePurchased]))
GO
ALTER TABLE [dbo].[PURCHASE] CHECK CONSTRAINT [CHK_DateReceived]
GO
ALTER TABLE [dbo].[PURCHASE]  WITH CHECK ADD  CONSTRAINT [CHK_UnitPricePaid] CHECK  (([UnitPricePaid]>(0.0)))
GO
ALTER TABLE [dbo].[PURCHASE] CHECK CONSTRAINT [CHK_UnitPricePaid]
GO
/****** Object:  StoredProcedure [dbo].[spCancelOrder]    Script Date: 7/31/2017 11:00:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[spCancelOrder] 
	-- Add the parameters for the stored procedure here
	@Order_Num int
AS

	if (IS_ROLEMEMBER('PR_SalesRole')) = 1
		begin
		if((select REP_NUM from SALESREP inner join employee on rep_num = EMPLOYEE.empID where SUSER_NAME() = EmpLogin) 
		!= (select customer.rep_num from customer inner join SALESREP on CUSTOMER.rep_num = SALESREP.REP_NUM  
		inner join orders on orders.CUST_NUM = customer.CUST_NUM where order_Num = @Order_Num))
			begin
			;
			throw 50001, 'Access to that order was denied', 1
			end
		end
	begin
		delete from order_line where order_num = @Order_Num;
		delete from orders where order_num = @Order_Num;
		
	
END

GO
GRANT EXECUTE ON [dbo].[spCancelOrder] TO [PR_SalesRole] AS [dbo]
GO
/****** Object:  StoredProcedure [dbo].[spSelectOrder]    Script Date: 7/31/2017 11:00:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE proc [dbo].[spSelectOrder]
	@Order_Num int

	as 

	if IS_ROLEMEMBER('PR_CustomerRole') = 1
		begin
		if ((select cust_num from orders where order_num = @Order_Num) !=
		(select cust_num from CUSTOMER where Cust_Login = SUSER_NAME()))
			begin
			;
			throw 50001, 'Access to that order was denied.', 1
			end
		end
	else if (IS_ROLEMEMBER('PR_SalesRole')) = 1
		begin
		if((select REP_NUM from SALESREP inner join employee on rep_num = EMPLOYEE.empID where SUSER_NAME() = EmpLogin) 
		!= (select customer.rep_num from customer inner join SALESREP on CUSTOMER.rep_num = SALESREP.REP_NUM  
		inner join orders on orders.CUST_NUM = customer.CUST_NUM where order_Num = @Order_Num))
			begin
			;
			throw 50001, 'Access to that order was denied', 1
			end
		end
	begin
		select * from orders where orders.order_num = @Order_Num;
		 
		

	end
GO
GRANT EXECUTE ON [dbo].[spSelectOrder] TO [PR_CustomerRole] AS [dbo]
GO
GRANT EXECUTE ON [dbo].[spSelectOrder] TO [PR_SalesRole] AS [dbo]
GO
/****** Object:  Trigger [dbo].[UpdateCustBalance]    Script Date: 7/31/2017 11:00:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE TRIGGER [dbo].[UpdateCustBalance]
   ON  [dbo].[ORDER_LINE] 
   AFTER  INSERT,DELETE,UPDATE
AS 
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	declare @orderNum nchar(10);
	declare @custNum nchar(10);
	declare @qty int;--how many were ordered
	declare @quotedPrice smallmoney;--price per item
	declare @subtotal smallmoney;--total charge for this item
	if exists (select * from inserted)
	  --a new record is being inserted into orderline
	  print 'inserting a new record'
	  begin
	    if exists (select * from deleted)
	    --part of an order is being updated
	      
	    begin
	        print 'replacing an orderline record'
	        select @qty = QTY_ORDERED from deleted
	        select @quotedPrice = QUOTED_PRICE from deleted
	        select @orderNum = order_num from deleted
	        set @subtotal = @quotedPrice * @qty
	        --find which customer placed this order
	        select @custNum =
	            cust_num from orders
	                where order_num = @orderNum
	        --find the customer record of this customer
	        update customer
	        set cust_balance = cust_balance - @subtotal
	        where cust_num = @custNum        
	    end  --end update
	    select @qty = qty_ordered from inserted
	    select @quotedPrice = quoted_price from inserted
	    select @orderNum = order_num from inserted
	    set @subtotal = @qty * @quotedPrice --how much
	        -- will be owed for this order
	    
	    print 'verify that have enough credit'    
	    declare @remainCredit smallmoney;
	    select @custNum =
	            cust_num from orders
	                where order_num = @orderNum
	    select @remainCredit =
	         credit_limit - cust_balance
	         from customer
	            inner join orders
	                on customer.cust_num = 
	                  orders.cust_num
	                  where orders.order_num=
	                     @orderNum
	    if @subtotal > @remainCredit
	        begin
	            raiserror('insufficient credit',10,1);
	            rollback transaction
	        end   
	    print 'now update customer balance to reflect this order'              
	   
	    update customer
	       set cust_balance = cust_balance + @subtotal
	        where cust_num = @custNum 
	    print 'update customer record'                   
	   end
	  
	if 
	     exists (select * from deleted)
	      if   not exists (select * from inserted)
	    --a  record is being deleted from  orderline
   begin
            print 'deleting data from order_line'
	        select @qty = qty_ordered from deleted
	        select @quotedPrice = quoted_price from deleted
	        select @orderNum = order_num from deleted
	        set @subtotal = @quotedPrice * @qty
	        --find which customer placed this order
	        select @custNum =
	            cust_num from orders
	                where order_num = @orderNum
	        --find the customer record of this customer
	        update customer
	        set cust_balance = cust_balance - @subtotal
	        where cust_num = @custNum        
	    end  --end update
    
      
END

GO
/****** Object:  Trigger [dbo].[UpdatePartsInv]    Script Date: 7/31/2017 11:00:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================



CREATE TRIGGER [dbo].[UpdatePartsInv]
   ON  [dbo].[ORDER_LINE]
   AFTER INSERT,DELETE,UPDATE
AS 
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

   Declare @PartNum nchar(10);
   Declare @qty smallint;
   Declare @qtyAvail smallint;
    if exists (select * from inserted)
    begin   --process an insert of a record
    if exists (select * from deleted)  --this is really an update
      begin       -- add the qty back to units on hand
       select @PartNum = Part_Num from deleted
       select @qty = qty_ordered from deleted
       update part
         set units_on_hand = units_on_hand + @qty
         where part_num = @PartNum
         
     end
      --continue to process the insert 
      select @PartNum = Part_Num from inserted
      select @qty = qty_ordered from inserted
   
      select @qtyAvail = units_on_hand from part
          where Part_Num = @PartNum
      --check if have enough inventory
      if @qtyAvail < @qty
          begin
             raiserror('insufficient inventory', 11,1)
             rollback transaction
          end     
       else
         --modify the part table
          update part
            set units_on_hand = units_on_hand - @qty
             where Part_Num = @PartNum   
    end   --process an insert or update
    else --just processing a delete
      begin
        select @PartNum = Part_Num from deleted
        select @qty = qty_ordered from deleted
        update part
         set units_on_hand = units_on_hand + @qty
         where part_num = @PartNum

      end  
  
END

------------------------------------------------------------

GO
USE [master]
GO
ALTER DATABASE [PREMIERE] SET  READ_WRITE 
GO
