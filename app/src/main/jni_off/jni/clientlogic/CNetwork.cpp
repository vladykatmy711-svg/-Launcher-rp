// -- -- -- -- -- -- -- 
// by weikton x reytiz
// -- -- -- -- -- -- --
#include "CNetwork.h"
#include <stdint.h>

#include "util/CJavaWrapper.h"

const char* g_szServerNames[MAX_SERVERS] = {
	"BLACK MOSCOW | RED",
	"BLACK RUSSIA | TEST"
};

const CSetServer::CServerInstanceEncrypted g_sEncryptedAddresses[MAX_SERVERS] = {
	CSetServer::create("141.94.184.111", 1, 16, 1717, false),
	CSetServer::create("141.94.184.111", 1, 16, 1717, false)	
};