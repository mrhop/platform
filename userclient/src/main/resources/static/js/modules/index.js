webpackJsonp([2],{

/***/ 0:
/*!************************************!*\
  !*** ./js/modules/index/index.jsx ***!
  \************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(ConfigureStore, ReactRouterRedux, ReactRouter, ReactDOM, React, RootContainer) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	var _reducers = __webpack_require__(/*! ./reducers */ 839);
	
	var _reducers2 = _interopRequireDefault(_reducers);
	
	var _routes = __webpack_require__(/*! ./routes */ 852);
	
	var _routes2 = _interopRequireDefault(_routes);
	
	var _middleware = __webpack_require__(/*! ./middleware */ 898);
	
	var _middleware2 = _interopRequireDefault(_middleware);
	
	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }
	
	var store = ConfigureStore.configureStore({ reducer: _reducers2.default, middleware: _middleware2.default }); /**
	                                                                                                               * Created by Donghui Huo on 2016/5/11.
	                                                                                                               */
	
	var history = ReactRouterRedux.syncHistoryWithStore(ReactRouter.browserHistory, store);
	
	ReactDOM.render(React.createElement(RootContainer, { store: store, history: history, routes: _routes2.default }), document.querySelector('#entirety'));
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! ./js/modules/common/store/configureStore.js */ 550), __webpack_require__(/*! react-router-redux */ 771), __webpack_require__(/*! react-router */ 776), __webpack_require__(/*! react-dom */ 35), __webpack_require__(/*! react */ 2), __webpack_require__(/*! ./js/modules/common/containers/Root.js */ 837)))

/***/ },

/***/ 839:
/*!********************************************!*\
  !*** ./js/modules/index/reducers/index.js ***!
  \********************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(ReactRouterRedux, Redux) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	
	var _reducers = __webpack_require__(/*! ../../include/dashBoard/reducers */ 840);
	
	var _reducers2 = _interopRequireDefault(_reducers);
	
	var _dashBoard = __webpack_require__(/*! ./dashBoard */ 842);
	
	var _dashBoard2 = _interopRequireDefault(_dashBoard);
	
	var _table = __webpack_require__(/*! ./table */ 845);
	
	var _table2 = _interopRequireDefault(_table);
	
	var _chart = __webpack_require__(/*! ./chart */ 848);
	
	var _chart2 = _interopRequireDefault(_chart);
	
	var _reducers3 = __webpack_require__(/*! ../../common/form/reducers */ 850);
	
	var _reducers4 = _interopRequireDefault(_reducers3);
	
	var _reducers5 = __webpack_require__(/*! ../../common/dragDrop/reducers */ 851);
	
	var _reducers6 = _interopRequireDefault(_reducers5);
	
	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }
	
	var routing = ReactRouterRedux.routerReducer;
	var rootReducer = Redux.combineReducers({
	    dashBoardFramework: _reducers2.default,
	    dashBoard: _dashBoard2.default,
	    table: _table2.default,
	    chart: _chart2.default,
	    form: _reducers4.default,
	    dragDrop: _reducers6.default,
	    routing: routing
	});
	exports.default = rootReducer;
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! react-router-redux */ 771), __webpack_require__(/*! redux */ 349)))

/***/ },

/***/ 840:
/*!********************************************************!*\
  !*** ./js/modules/include/dashBoard/reducers/index.js ***!
  \********************************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(l_merge, Redux) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	
	var _actions = __webpack_require__(/*! ../actions/ */ 841);
	
	var ActionTypes = _interopRequireWildcard(_actions);
	
	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }
	
	function leftMenuData() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? {} : arguments[0];
	    var action = arguments[1];
	
	    if (action.type === ActionTypes.DASHBOARD_FRAMEWORK_LEFTMENU_SUCCESS) {
	        state.data = action.response;
	        state.requestCondition = action['requestCondition'];
	        return l_merge({}, state);
	    }
	    if (action.type === '@@router/LOCATION_CHANGE') {}
	    if (action.type === ActionTypes.DASHBOARD_FRAMEWORK_LEFTMENU_COLLAPSE_CHANGE) {
	        var collapse = false;
	        if (state.collapse !== undefined) {
	            collapse = !state.collapse;
	        }
	        return l_merge({}, state, { collapse: action.requestCondition.collapse });
	    }
	    if (action.type === ActionTypes.DASHBOARD_FRAMEWORK_LEFTMENU_SELECT_CHANGE) {
	
	        return l_merge({}, state, { selectedUrl: action.requestCondition.selectedUrl });
	    }
	    return state;
	}
	
	exports.default = Redux.combineReducers({ leftMenuData: leftMenuData });
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! lodash/merge */ 510), __webpack_require__(/*! redux */ 349)))

/***/ },

/***/ 841:
/*!*******************************************************!*\
  !*** ./js/modules/include/dashBoard/actions/index.js ***!
  \*******************************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(MiddleWare) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.getLeftMenuDispatch = getLeftMenuDispatch;
	exports.leftMenuCollapseChange = leftMenuCollapseChange;
	exports.leftMenuSelectedChange = leftMenuSelectedChange;
	
	function _defineProperty(obj, key, value) { if (key in obj) { Object.defineProperty(obj, key, { value: value, enumerable: true, configurable: true, writable: true }); } else { obj[key] = value; } return obj; }
	
	var DASHBOARD_FRAMEWORK_LEFTMENU_REQUEST = exports.DASHBOARD_FRAMEWORK_LEFTMENU_REQUEST = 'DASHBOARD_FRAMEWORK_LEFTMENU_REQUEST';
	var DASHBOARD_FRAMEWORK_LEFTMENU_SUCCESS = exports.DASHBOARD_FRAMEWORK_LEFTMENU_SUCCESS = 'DASHBOARD_FRAMEWORK_LEFTMENU_SUCCESS';
	var DASHBOARD_FRAMEWORK_LEFTMENU_FAILURE = exports.DASHBOARD_FRAMEWORK_LEFTMENU_FAILURE = 'DASHBOARD_FRAMEWORK_LEFTMENU_FAILURE';
	var DASHBOARD_FRAMEWORK_LEFTMENU_COLLAPSE_CHANGE = exports.DASHBOARD_FRAMEWORK_LEFTMENU_COLLAPSE_CHANGE = 'DASHBOARD_FRAMEWORK_LEFTMENU_COLLAPSE_CHANGE';
	var DASHBOARD_FRAMEWORK_LEFTMENU_SELECT_CHANGE = exports.DASHBOARD_FRAMEWORK_LEFTMENU_SELECT_CHANGE = 'DASHBOARD_FRAMEWORK_LEFTMENU_SELECT_CHANGE';
	
	// /index  &&/ demoTable  action
	function getLeftMenu(requestCondition) {
	    var _ref;
	
	    return _ref = {}, _defineProperty(_ref, MiddleWare.CALL_API, {
	        httpType: 'get',
	        types: [DASHBOARD_FRAMEWORK_LEFTMENU_REQUEST, DASHBOARD_FRAMEWORK_LEFTMENU_SUCCESS, DASHBOARD_FRAMEWORK_LEFTMENU_FAILURE],
	        endpoint: endpoints.dashboardleftmenu
	    }), _defineProperty(_ref, 'requestCondition', requestCondition), _ref;
	}
	function getLeftMenuDispatch(requestCondition) {
	    return function (dispatch, getState) {
	        return dispatch(getLeftMenu(requestCondition));
	    };
	}
	
	function leftMenuCollapseChange(requestCondition) {
	    return function (dispatch, getState) {
	        return dispatch({ requestCondition: requestCondition, type: DASHBOARD_FRAMEWORK_LEFTMENU_COLLAPSE_CHANGE });
	    };
	}
	
	function leftMenuSelectedChange(requestCondition) {
	    return function (dispatch, getState) {
	        return dispatch({ requestCondition: requestCondition, type: DASHBOARD_FRAMEWORK_LEFTMENU_SELECT_CHANGE });
	    };
	}
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! ./js/modules/common/middleware/index.js */ 364)))

/***/ },

/***/ 842:
/*!************************************************!*\
  !*** ./js/modules/index/reducers/dashBoard.js ***!
  \************************************************/
/***/ function(module, exports, __webpack_require__) {

	/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	var _dashBoard = __webpack_require__(/*! ../actions/dashBoard */ 843);
	
	var ActionTypes = _interopRequireWildcard(_dashBoard);
	
	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "dashBoard.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }

/***/ },

/***/ 843:
/*!***********************************************!*\
  !*** ./js/modules/index/actions/dashBoard.js ***!
  \***********************************************/
/***/ function(module, exports, __webpack_require__) {

	/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	var _dashBoard = __webpack_require__(/*! ../middleware/dashBoard */ 844);
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "dashBoard.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }

/***/ },

/***/ 844:
/*!**************************************************!*\
  !*** ./js/modules/index/middleware/dashBoard.js ***!
  \**************************************************/
/***/ function(module, exports, __webpack_require__) {

	/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	"use strict";
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	
	//index demo table----------------------------------------------------------------------------
	
	//--schema
	
	
	exports.default = function (store) {
	    return function (next) {
	        return function (action) {
	            //now do nothing,just to the next layer
	            return next(action);
	        };
	    };
	};
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "dashBoard.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }

/***/ },

/***/ 845:
/*!********************************************!*\
  !*** ./js/modules/index/reducers/table.js ***!
  \********************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(l_merge, Redux) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	
	var _table = __webpack_require__(/*! ../actions/table */ 846);
	
	var ActionTypes = _interopRequireWildcard(_table);
	
	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }
	
	function demoTable() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? { keys: [], demoTableData: {} } : arguments[0];
	    var action = arguments[1];
	
	    if (action.type === ActionTypes.INDEX_DEMO_TABLE_SUCCESS) {
	        state.keys = action.response.result;
	        state.requestCondition = action['requestCondition'];
	        state.demoTableRefresh = false;
	        return l_merge({}, state, action.response.entities, { totalCount: 23 });
	    }
	    if (action.type === ActionTypes.INDEX_DEMO_TABLE_DELETE_SUCCESS || action.type === ActionTypes.INDEX_DEMO_TABLE_ADD_SUCCESS) {
	        return l_merge({}, state, { demoTableRefresh: true });
	    }
	    return state;
	}
	
	//shall do nothing ,but use the data get back from server the render,this is just the test to see the state change
	//recatch data = true
	function demoTableDelete() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? {} : arguments[0];
	    var action = arguments[1];
	
	    if (action.type === ActionTypes.INDEX_DEMO_TABLE_DELETE_SUCCESS) {}
	    return state;
	}
	
	exports.default = Redux.combineReducers({ demoTable: demoTable, demoTableDelete: demoTableDelete });
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "table.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! lodash/merge */ 510), __webpack_require__(/*! redux */ 349)))

/***/ },

/***/ 846:
/*!*******************************************!*\
  !*** ./js/modules/index/actions/table.js ***!
  \*******************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(MiddleWare) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.INDEX_DEMO_TABLE_UPDATE_COLUMN_FAILURE = exports.INDEX_DEMO_TABLE_UPDATE_COLUMN_SUCCESS = exports.INDEX_DEMO_TABLE_UPDATE_COLUMN_REQUEST = exports.INDEX_DEMO_TABLE_UPDATE_FAILURE = exports.INDEX_DEMO_TABLE_UPDATE_SUCCESS = exports.INDEX_DEMO_TABLE_UPDATE_REQUEST = exports.INDEX_DEMO_TABLE_ADD_FAILURE = exports.INDEX_DEMO_TABLE_ADD_SUCCESS = exports.INDEX_DEMO_TABLE_ADD_REQUEST = exports.INDEX_DEMO_TABLE_DELETE_FAILURE = exports.INDEX_DEMO_TABLE_DELETE_SUCCESS = exports.INDEX_DEMO_TABLE_DELETE_REQUEST = exports.INDEX_DEMO_TABLE_FAILURE = exports.INDEX_DEMO_TABLE_SUCCESS = exports.INDEX_DEMO_TABLE_REQUEST = undefined;
	exports.getIndexDemoTableDispatch = getIndexDemoTableDispatch;
	exports.deleteDemoTableDispatch = deleteDemoTableDispatch;
	exports.addDemoTableDispatch = addDemoTableDispatch;
	exports.updateDemoTableDispatch = updateDemoTableDispatch;
	exports.updateColumnDemoTableDispatch = updateColumnDemoTableDispatch;
	exports.refreshDemoTableDispatch = refreshDemoTableDispatch;
	
	var _table = __webpack_require__(/*! ../middleware/table */ 847);
	
	function _defineProperty(obj, key, value) { if (key in obj) { Object.defineProperty(obj, key, { value: value, enumerable: true, configurable: true, writable: true }); } else { obj[key] = value; } return obj; }
	
	var INDEX_DEMO_TABLE_REQUEST = exports.INDEX_DEMO_TABLE_REQUEST = 'INDEX_DEMO_TABLE_REQUEST';
	var INDEX_DEMO_TABLE_SUCCESS = exports.INDEX_DEMO_TABLE_SUCCESS = 'INDEX_DEMO_TABLE_SUCCESS';
	var INDEX_DEMO_TABLE_FAILURE = exports.INDEX_DEMO_TABLE_FAILURE = 'INDEX_DEMO_TABLE_FAILURE';
	
	var INDEX_DEMO_TABLE_DELETE_REQUEST = exports.INDEX_DEMO_TABLE_DELETE_REQUEST = 'INDEX_DEMO_TABLE_DELETE_REQUEST';
	var INDEX_DEMO_TABLE_DELETE_SUCCESS = exports.INDEX_DEMO_TABLE_DELETE_SUCCESS = 'INDEX_DEMO_TABLE_DELETE_SUCCESS';
	var INDEX_DEMO_TABLE_DELETE_FAILURE = exports.INDEX_DEMO_TABLE_DELETE_FAILURE = 'INDEX_DEMO_TABLE_DELETE_FAILURE';
	
	var INDEX_DEMO_TABLE_ADD_REQUEST = exports.INDEX_DEMO_TABLE_ADD_REQUEST = 'INDEX_DEMO_TABLE_ADD_REQUEST';
	var INDEX_DEMO_TABLE_ADD_SUCCESS = exports.INDEX_DEMO_TABLE_ADD_SUCCESS = 'INDEX_DEMO_TABLE_ADD_SUCCESS';
	var INDEX_DEMO_TABLE_ADD_FAILURE = exports.INDEX_DEMO_TABLE_ADD_FAILURE = 'INDEX_DEMO_TABLE_ADD_FAILURE';
	
	var INDEX_DEMO_TABLE_UPDATE_REQUEST = exports.INDEX_DEMO_TABLE_UPDATE_REQUEST = 'INDEX_DEMO_TABLE_UPDATE_REQUEST';
	var INDEX_DEMO_TABLE_UPDATE_SUCCESS = exports.INDEX_DEMO_TABLE_UPDATE_SUCCESS = 'INDEX_DEMO_TABLE_UPDATE_SUCCESS';
	var INDEX_DEMO_TABLE_UPDATE_FAILURE = exports.INDEX_DEMO_TABLE_UPDATE_FAILURE = 'INDEX_DEMO_TABLE_UPDATE_FAILURE';
	
	var INDEX_DEMO_TABLE_UPDATE_COLUMN_REQUEST = exports.INDEX_DEMO_TABLE_UPDATE_COLUMN_REQUEST = 'INDEX_DEMO_TABLE_UPDATE_COLUMN_REQUEST';
	var INDEX_DEMO_TABLE_UPDATE_COLUMN_SUCCESS = exports.INDEX_DEMO_TABLE_UPDATE_COLUMN_SUCCESS = 'INDEX_DEMO_TABLE_UPDATE_COLUMN_SUCCESS';
	var INDEX_DEMO_TABLE_UPDATE_COLUMN_FAILURE = exports.INDEX_DEMO_TABLE_UPDATE_COLUMN_FAILURE = 'INDEX_DEMO_TABLE_UPDATE_COLUMN_FAILURE';
	
	// /index  &&/ demoTable  action
	function getIndexDemoTable(requestCondition) {
	    var _ref;
	
	    return _ref = {}, _defineProperty(_ref, MiddleWare.CALL_API, {
	        httpType: 'get',
	        types: [INDEX_DEMO_TABLE_REQUEST, INDEX_DEMO_TABLE_SUCCESS, INDEX_DEMO_TABLE_FAILURE],
	        schema: _table.Schemas.DemoTable,
	        endpoint: 'demoData/table/tableData.json'
	    }), _defineProperty(_ref, 'requestCondition', requestCondition), _ref;
	}
	function getIndexDemoTableDispatch() {
	    var requestCondition = arguments.length <= 0 || arguments[0] === undefined ? {
	        filters: null,
	        sort: null,
	        rowSize: null,
	        currentPage: 0
	    } : arguments[0];
	
	    return function (dispatch, getState) {
	        return dispatch(getIndexDemoTable(requestCondition));
	    };
	}
	function deleteDemoTable() {
	    var _ref2;
	
	    var requestCondition = arguments.length <= 0 || arguments[0] === undefined ? { key: null } : arguments[0];
	
	    return _ref2 = {}, _defineProperty(_ref2, MiddleWare.CALL_API, {
	        httpType: 'delete',
	        types: [INDEX_DEMO_TABLE_DELETE_REQUEST, INDEX_DEMO_TABLE_DELETE_SUCCESS, INDEX_DEMO_TABLE_DELETE_FAILURE],
	        schema: _table.Schemas.DemoTable,
	        endpoint: 'demoData/table/deleteData.json'
	    }), _defineProperty(_ref2, 'requestCondition', requestCondition), _ref2;
	}
	function deleteDemoTableDispatch() {
	    var requestCondition = arguments.length <= 0 || arguments[0] === undefined ? { key: null } : arguments[0];
	
	    return function (dispatch, getState) {
	        return dispatch(deleteDemoTable(requestCondition));
	    };
	}
	
	function addDemoTable(requestCondition) {
	    var _ref3;
	
	    return _ref3 = {}, _defineProperty(_ref3, MiddleWare.CALL_API, {
	        httpType: 'POST',
	        types: [INDEX_DEMO_TABLE_ADD_REQUEST, INDEX_DEMO_TABLE_ADD_SUCCESS, INDEX_DEMO_TABLE_ADD_FAILURE],
	        schema: _table.Schemas.DemoTableRow,
	        endpoint: 'demoData/table/addData.json'
	    }), _defineProperty(_ref3, 'requestCondition', requestCondition), _ref3;
	}
	function addDemoTableDispatch() {
	    var requestCondition = arguments.length <= 0 || arguments[0] === undefined ? { firstName: firstName, lastName: lastName, username: username, email: email, age: age } : arguments[0];
	
	    return function (dispatch, getState) {
	        return dispatch(addDemoTable(requestCondition));
	    };
	}
	
	function updateDemoTable(requestCondition) {
	    var _ref4;
	
	    return _ref4 = {}, _defineProperty(_ref4, MiddleWare.CALL_API, {
	        httpType: 'POST',
	        types: [INDEX_DEMO_TABLE_UPDATE_REQUEST, INDEX_DEMO_TABLE_UPDATE_SUCCESS, INDEX_DEMO_TABLE_UPDATE_FAILURE],
	        schema: _table.Schemas.DemoTableRow,
	        endpoint: 'demoData/table/updateData.json'
	    }), _defineProperty(_ref4, 'requestCondition', requestCondition), _ref4;
	}
	function updateDemoTableDispatch() {
	    var requestCondition = arguments.length <= 0 || arguments[0] === undefined ? { key: key, firstName: firstName, lastName: lastName, username: username, email: email, age: age } : arguments[0];
	
	    return function (dispatch, getState) {
	        return dispatch(updateDemoTable(requestCondition));
	    };
	}
	
	function updateColumnDemoTable(requestCondition) {
	    var _ref5;
	
	    return _ref5 = {}, _defineProperty(_ref5, MiddleWare.CALL_API, {
	        httpType: 'POST',
	        types: [INDEX_DEMO_TABLE_UPDATE_COLUMN_REQUEST, INDEX_DEMO_TABLE_UPDATE_COLUMN_SUCCESS, INDEX_DEMO_TABLE_UPDATE_COLUMN_FAILURE],
	        schema: _table.Schemas.DemoTableRow,
	        endpoint: 'demoData/table/updateData.json'
	    }), _defineProperty(_ref5, 'requestCondition', requestCondition), _ref5;
	}
	function updateColumnDemoTableDispatch() {
	    var requestCondition = arguments.length <= 0 || arguments[0] === undefined ? { key: key } : arguments[0];
	
	    return function (dispatch, getState) {
	        return dispatch(updateColumnDemoTable(requestCondition));
	    };
	}
	
	//refresh
	function refreshDemoTableDispatch() {
	    return function (dispatch, getState) {
	        var requestCondition = getState().dashBoard.demoTable.requestCondition;
	
	        return dispatch(getIndexDemoTable(requestCondition));
	    };
	}
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "table.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! ./js/modules/common/middleware/index.js */ 364)))

/***/ },

/***/ 847:
/*!**********************************************!*\
  !*** ./js/modules/index/middleware/table.js ***!
  \**********************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(normalizr) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	//index demo table----------------------------------------------------------------------------
	
	//--schema
	var demoTableRowSchema = new normalizr.Schema('demoTableData', {
	    idAttribute: function idAttribute(rowData) {
	        return rowData.key;
	    }
	});
	var Schemas = exports.Schemas = {
	    DemoTableRow: demoTableRowSchema,
	    DemoTable: normalizr.arrayOf(demoTableRowSchema)
	};
	//--DEMOtABLE STRUCTURE
	var demoTableRules = exports.demoTableRules = {
	    thead: [{
	        className: 'td-id',
	        title: '#',
	        value: 'serialNum',
	        sort: 'asc',
	        filter: false
	    }, {
	        title: 'First Name',
	        value: 'firstName',
	        filter: true,
	        editable: true,
	        addable: true,
	        editType: 'select',
	        columnEditable: true,
	        editValue: [{ label: 'select 1', value: 'Mark' }, { label: 'select 2', value: 'Mark1' }]
	    }, {
	        title: 'Last Name', value: 'lastName', filter: true, editable: true, addable: true, columnEditable: true,
	        editType: 'radio', editValue: [{ label: 'type 1', value: 'Otto' }, { label: 'type 2', value: 'Otto1' }]
	    }, {
	        title: 'Username',
	        value: 'username',
	        filter: true,
	        editable: true,
	        addable: true,
	        columnEditable: true, //single column edit
	        editType: 'text'
	    }, {
	        title: 'Email',
	        value: 'email',
	        columnEditable: true,
	        editable: true,
	        editType: 'text',
	        addable: true,
	        filter: true
	    }, {
	        title: 'Age',
	        value: 'age',
	        filter: true,
	        editable: true,
	        addable: true,
	        editType: 'checkbox',
	        columnEditable: true,
	        editValue: [{ label: '31', value: '31' }, { label: '32', value: '32' }]
	    }],
	    tfoot: [{
	        className: 'td-foot',
	        colSpan: 7,
	        title: 'this is the footer for this table'
	    }]
	};
	var rowEditableAdditionalFeature = exports.rowEditableAdditionalFeature = {
	    extraClass: 'hover',
	    sortAvailable: true,
	    filterAvailable: true,
	    pager: {
	        show: true,
	        rowSize: {
	            show: true
	        }
	    }
	};
	
	exports.default = function (store) {
	    return function (next) {
	        return function (action) {
	            //now do nothing,just to the next layer
	            return next(action);
	        };
	    };
	};
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "table.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! normalizr */ 459)))

/***/ },

/***/ 848:
/*!********************************************!*\
  !*** ./js/modules/index/reducers/chart.js ***!
  \********************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(l_merge, Redux) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	
	var _chart = __webpack_require__(/*! ../actions/chart */ 849);
	
	var ActionTypes = _interopRequireWildcard(_chart);
	
	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }
	
	function demoLineChartData() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? {} : arguments[0];
	    var action = arguments[1];
	
	    if (action.type === ActionTypes.LINE_DEMO_CHART_SUCCESS) {
	        state.data = action.response;
	        state.requestCondition = action['requestCondition'];
	        return l_merge({}, state);
	    }
	    return state;
	}
	
	function demoAreaChartData() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? {} : arguments[0];
	    var action = arguments[1];
	
	    if (action.type === ActionTypes.AREA_DEMO_CHART_SUCCESS) {
	        state.data = action.response;
	        state.requestCondition = action['requestCondition'];
	        return l_merge({}, state);
	    }
	    return state;
	}
	
	function demoBarChartData() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? {} : arguments[0];
	    var action = arguments[1];
	
	    if (action.type === ActionTypes.BAR_DEMO_CHART_SUCCESS) {
	        state.data = action.response;
	        state.requestCondition = action['requestCondition'];
	        return l_merge({}, state);
	    }
	    return state;
	}
	
	function demoPieChartData() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? {} : arguments[0];
	    var action = arguments[1];
	
	    if (action.type === ActionTypes.PIE_DEMO_CHART_SUCCESS) {
	        state.data = action.response;
	        state.requestCondition = action['requestCondition'];
	        return l_merge({}, state);
	    }
	    return state;
	}
	
	function demoScatterChartData() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? {} : arguments[0];
	    var action = arguments[1];
	
	    if (action.type === ActionTypes.SCATTER_DEMO_CHART_SUCCESS) {
	        state.data = action.response;
	        state.requestCondition = action['requestCondition'];
	        return l_merge({}, state);
	    }
	    return state;
	}
	
	function demoTreemapChartData() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? {} : arguments[0];
	    var action = arguments[1];
	
	    if (action.type === ActionTypes.TREEMAP_DEMO_CHART_SUCCESS) {
	        state.data = action.response;
	        state.requestCondition = action['requestCondition'];
	        return l_merge({}, state);
	    }
	    return state;
	}
	
	exports.default = Redux.combineReducers({ demoLineChartData: demoLineChartData, demoAreaChartData: demoAreaChartData, demoBarChartData: demoBarChartData, demoPieChartData: demoPieChartData, demoScatterChartData: demoScatterChartData, demoTreemapChartData: demoTreemapChartData });
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "chart.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! lodash/merge */ 510), __webpack_require__(/*! redux */ 349)))

/***/ },

/***/ 849:
/*!*******************************************!*\
  !*** ./js/modules/index/actions/chart.js ***!
  \*******************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(MiddleWare) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.getDemoLineChartDispatch = getDemoLineChartDispatch;
	exports.getDemoAreaChartDispatch = getDemoAreaChartDispatch;
	exports.getDemoBarChartDispatch = getDemoBarChartDispatch;
	exports.getDemoPieChartDispatch = getDemoPieChartDispatch;
	exports.getDemoScatterChartDispatch = getDemoScatterChartDispatch;
	exports.getDemoTreemapChartDispatch = getDemoTreemapChartDispatch;
	
	function _defineProperty(obj, key, value) { if (key in obj) { Object.defineProperty(obj, key, { value: value, enumerable: true, configurable: true, writable: true }); } else { obj[key] = value; } return obj; }
	
	var LINE_DEMO_CHART_REQUEST = exports.LINE_DEMO_CHART_REQUEST = 'LINE_DEMO_CHART_REQUEST';
	var LINE_DEMO_CHART_SUCCESS = exports.LINE_DEMO_CHART_SUCCESS = 'LINE_DEMO_CHART_SUCCESS';
	var LINE_DEMO_CHART_FAILURE = exports.LINE_DEMO_CHART_FAILURE = 'LINE_DEMO_CHART_FAILURE';
	
	var AREA_DEMO_CHART_REQUEST = exports.AREA_DEMO_CHART_REQUEST = 'AREA_DEMO_CHART_REQUEST';
	var AREA_DEMO_CHART_SUCCESS = exports.AREA_DEMO_CHART_SUCCESS = 'AREA_DEMO_CHART_SUCCESS';
	var AREA_DEMO_CHART_FAILURE = exports.AREA_DEMO_CHART_FAILURE = 'AREA_DEMO_CHART_FAILURE';
	
	var BAR_DEMO_CHART_REQUEST = exports.BAR_DEMO_CHART_REQUEST = 'BAR_DEMO_CHART_REQUEST';
	var BAR_DEMO_CHART_SUCCESS = exports.BAR_DEMO_CHART_SUCCESS = 'BAR_DEMO_CHART_SUCCESS';
	var BAR_DEMO_CHART_FAILURE = exports.BAR_DEMO_CHART_FAILURE = 'BAR_DEMO_CHART_FAILURE';
	
	var PIE_DEMO_CHART_REQUEST = exports.PIE_DEMO_CHART_REQUEST = 'PIE_DEMO_CHART_REQUEST';
	var PIE_DEMO_CHART_SUCCESS = exports.PIE_DEMO_CHART_SUCCESS = 'PIE_DEMO_CHART_SUCCESS';
	var PIE_DEMO_CHART_FAILURE = exports.PIE_DEMO_CHART_FAILURE = 'PIE_DEMO_CHART_FAILURE';
	
	var SCATTER_DEMO_CHART_REQUEST = exports.SCATTER_DEMO_CHART_REQUEST = 'SCATTER_DEMO_CHART_REQUEST';
	var SCATTER_DEMO_CHART_SUCCESS = exports.SCATTER_DEMO_CHART_SUCCESS = 'SCATTER_DEMO_CHART_SUCCESS';
	var SCATTER_DEMO_CHART_FAILURE = exports.SCATTER_DEMO_CHART_FAILURE = 'SCATTER_DEMO_CHART_FAILURE';
	
	var TREEMAP_DEMO_CHART_REQUEST = exports.TREEMAP_DEMO_CHART_REQUEST = 'TREEMAP_DEMO_CHART_REQUEST';
	var TREEMAP_DEMO_CHART_SUCCESS = exports.TREEMAP_DEMO_CHART_SUCCESS = 'TREEMAP_DEMO_CHART_SUCCESS';
	var TREEMAP_DEMO_CHART_FAILURE = exports.TREEMAP_DEMO_CHART_FAILURE = 'TREEMAP_DEMO_CHART_FAILURE';
	
	function getDemoLineChart(requestCondition) {
	    var _ref;
	
	    return _ref = {}, _defineProperty(_ref, MiddleWare.CALL_API, {
	        httpType: 'get',
	        types: [LINE_DEMO_CHART_REQUEST, LINE_DEMO_CHART_SUCCESS, LINE_DEMO_CHART_FAILURE],
	        endpoint: 'demoData/chartData/line.json'
	    }), _defineProperty(_ref, 'requestCondition', requestCondition), _ref;
	}
	function getDemoLineChartDispatch() {
	    var requestCondition = arguments.length <= 0 || arguments[0] === undefined ? {
	        filters: null
	    } : arguments[0];
	
	    return function (dispatch, getState) {
	        return dispatch(getDemoLineChart(requestCondition));
	    };
	}
	
	function getDemoAreaChart(requestCondition) {
	    var _ref2;
	
	    return _ref2 = {}, _defineProperty(_ref2, MiddleWare.CALL_API, {
	        httpType: 'get',
	        types: [AREA_DEMO_CHART_REQUEST, AREA_DEMO_CHART_SUCCESS, AREA_DEMO_CHART_FAILURE],
	        endpoint: 'demoData/chartData/area.json'
	    }), _defineProperty(_ref2, 'requestCondition', requestCondition), _ref2;
	}
	function getDemoAreaChartDispatch() {
	    var requestCondition = arguments.length <= 0 || arguments[0] === undefined ? {
	        filters: null
	    } : arguments[0];
	
	    return function (dispatch, getState) {
	        return dispatch(getDemoAreaChart(requestCondition));
	    };
	}
	
	function getDemoBarChart(requestCondition) {
	    var _ref3;
	
	    return _ref3 = {}, _defineProperty(_ref3, MiddleWare.CALL_API, {
	        httpType: 'get',
	        types: [BAR_DEMO_CHART_REQUEST, BAR_DEMO_CHART_SUCCESS, BAR_DEMO_CHART_FAILURE],
	        endpoint: 'demoData/chartData/bar.json'
	    }), _defineProperty(_ref3, 'requestCondition', requestCondition), _ref3;
	}
	function getDemoBarChartDispatch() {
	    var requestCondition = arguments.length <= 0 || arguments[0] === undefined ? {
	        filters: null
	    } : arguments[0];
	
	    return function (dispatch, getState) {
	        return dispatch(getDemoBarChart(requestCondition));
	    };
	}
	
	function getDemoPieChart(requestCondition) {
	    var _ref4;
	
	    return _ref4 = {}, _defineProperty(_ref4, MiddleWare.CALL_API, {
	        httpType: 'get',
	        types: [PIE_DEMO_CHART_REQUEST, PIE_DEMO_CHART_SUCCESS, SCATTER_DEMO_CHART_FAILURE],
	        endpoint: 'demoData/chartData/pie.json'
	    }), _defineProperty(_ref4, 'requestCondition', requestCondition), _ref4;
	}
	function getDemoPieChartDispatch() {
	    var requestCondition = arguments.length <= 0 || arguments[0] === undefined ? {
	        filters: null
	    } : arguments[0];
	
	    return function (dispatch, getState) {
	        return dispatch(getDemoPieChart(requestCondition));
	    };
	}
	
	function getDemoScatterChart(requestCondition) {
	    var _ref5;
	
	    return _ref5 = {}, _defineProperty(_ref5, MiddleWare.CALL_API, {
	        httpType: 'get',
	        types: [SCATTER_DEMO_CHART_REQUEST, SCATTER_DEMO_CHART_SUCCESS, SCATTER_DEMO_CHART_FAILURE],
	        endpoint: 'demoData/chartData/scatter.json'
	    }), _defineProperty(_ref5, 'requestCondition', requestCondition), _ref5;
	}
	function getDemoScatterChartDispatch() {
	    var requestCondition = arguments.length <= 0 || arguments[0] === undefined ? {
	        filters: null
	    } : arguments[0];
	
	    return function (dispatch, getState) {
	        return dispatch(getDemoScatterChart(requestCondition));
	    };
	}
	
	function getDemoTreemapChart(requestCondition) {
	    var _ref6;
	
	    return _ref6 = {}, _defineProperty(_ref6, MiddleWare.CALL_API, {
	        httpType: 'get',
	        types: [TREEMAP_DEMO_CHART_REQUEST, TREEMAP_DEMO_CHART_SUCCESS, TREEMAP_DEMO_CHART_FAILURE],
	        endpoint: 'demoData/chartData/treemap.json'
	    }), _defineProperty(_ref6, 'requestCondition', requestCondition), _ref6;
	}
	function getDemoTreemapChartDispatch() {
	    var requestCondition = arguments.length <= 0 || arguments[0] === undefined ? {
	        filters: null
	    } : arguments[0];
	
	    return function (dispatch, getState) {
	        return dispatch(getDemoTreemapChart(requestCondition));
	    };
	}
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "chart.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! ./js/modules/common/middleware/index.js */ 364)))

/***/ },

/***/ 850:
/*!**************************************************!*\
  !*** ./js/modules/common/form/reducers/index.js ***!
  \**************************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(l_merge, Redux) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	
	var _actions = __webpack_require__(/*! ../actions */ 363);
	
	var ActionTypes = _interopRequireWildcard(_actions);
	
	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }
	
	function main() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? {} : arguments[0];
	    var action = arguments[1];
	
	    if (action.type === ActionTypes.FORM_INIT) {
	        //from 初始化时设置，判断id是否存在
	        state[action.formKey] = {};
	        state[action.formKey].rule = action.rule;
	        state[action.formKey].status = 'init';
	        state[action.formKey].submitProcess = { status: false };
	        return l_merge({}, state);
	    }
	    if (action.type === ActionTypes.FORM_VALIDATE_FAILURE) {
	        state[action.formKey].rule.structure = action.structure;
	        state[action.formKey].submitProcess = { status: false };
	        return l_merge({}, state);
	    }
	
	    if (action.type === ActionTypes.FORM_POST_SUCCESS) {
	        //将action.response和 validateFailureMsg 合并,并返回;
	        state[action.requestCondition.formKey].submitProcess = { status: false };
	        if (action.response) {
	            state[action.requestCondition.formKey].status = action.response.status;
	            if (action.response.message) {
	                state[action.requestCondition.formKey].message = action.response.message;
	            }
	            if (action.response.responseData) {
	                state[action.requestCondition.formKey].responseData = action.response.responseData;
	            }
	        }
	        return l_merge({}, state);
	    }
	
	    if (action.type === ActionTypes.FORM_POST_FAILURE) {
	        state[action.requestCondition.formKey].submitProcess = { status: false };
	        state[action.requestCondition.formKey].status = 'serverFailure';
	        state[action.requestCondition.formKey].failureMsg = action.error;
	        return l_merge({}, state);
	    }
	    return state;
	}
	
	exports.default = Redux.combineReducers({ main: main });
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! lodash/merge */ 510), __webpack_require__(/*! redux */ 349)))

/***/ },

/***/ 851:
/*!******************************************************!*\
  !*** ./js/modules/common/dragDrop/reducers/index.js ***!
  \******************************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(l_merge, Redux) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	"use strict";
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	
	var _actions = __webpack_require__(/*! ../actions */ 491);
	
	var ActionTypes = _interopRequireWildcard(_actions);
	
	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }
	
	function main() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? {} : arguments[0];
	    var action = arguments[1];
	
	    if (action.type === ActionTypes.INIT_WORK_FLOW_SUCCESS) {
	        //INIT env
	        state[action.requestCondition.symbol] = { flow: {} };
	        if (action.response) {
	            state[action.requestCondition.symbol].flow = {
	                data: action.response.data,
	                flowId: action.response.flowId,
	                flowName: action.response.flowName
	            };
	            if (action.requestCondition.url) {
	                if (window.localStorage) {
	                    window.localStorage["work_flow::" + action.requestCondition.symbol] = JSON.stringify(action.response);
	                }
	            }
	        }
	        return l_merge({}, state);
	    }
	    if (action.type === ActionTypes.ROLES_GET_SUCCESS) {
	        //get need rows
	        if (action.response) {
	            state[action.requestCondition.symbol].roles = action.response;
	        }
	        return l_merge({}, state);
	    }
	
	    if (action.type === ActionTypes.POSITIONS_GET_SUCCESS) {
	        //get need rows
	        if (action.response) {
	            state[action.requestCondition.symbol].positions = action.response;
	        }
	        return l_merge({}, state);
	    }
	
	    if (action.type === ActionTypes.SHOW_SAVE_WORK_FLOW_FORM) {
	        state[action.requestCondition.symbol].saveFlowVisible = true;
	        return l_merge({}, state);
	    }
	
	    if (action.type === ActionTypes.HIDE_SAVE_WORK_FLOW_FORM) {
	        state[action.requestCondition.symbol].saveFlowVisible = false;
	        return l_merge({}, state);
	    }
	
	    if (action.type === ActionTypes.SAVE_WORK_FLOW_SUCCESS) {
	        state[action.requestCondition.symbol].saveFlowVisible = false;
	        if (action.response.responseData && action.response.responseData.flowId) {
	            state[action.requestCondition.symbol].flow.flowId = action.response.responseData.flowId;
	            if (window.localStorage) {
	                window.localStorage["work_flow::" + action.requestCondition.symbol] = JSON.stringify(state[action.requestCondition.symbol].flow);
	            }
	            return l_merge({}, state);
	        }
	        return state;
	    }
	
	    if (action.type === ActionTypes.CLEAN_WORK_GROUP) {
	        state[action.requestCondition.symbol].flow.data = null;
	        return l_merge({}, state);
	    }
	
	    if (action.type === ActionTypes.SHOW_ELEMENT_FORM) {
	        state[action.requestCondition.symbol].addFormVisible = true;
	        state[action.requestCondition.symbol].dragElementForm = action.requestCondition.dragElementForm;
	        state[action.requestCondition.symbol].dragModalData = action.requestCondition.dragModalData;
	        return l_merge({}, state);
	    }
	    if (action.type === ActionTypes.HIDE_ELEMENT_FORM) {
	        state[action.requestCondition.symbol].addFormVisible = false;
	        state[action.requestCondition.symbol].dragElementForm = null;
	        state[action.requestCondition.symbol].dragModalData = null;
	        return l_merge({}, state);
	    }
	
	    if (action.type === ActionTypes.AFTER_SAVE_ELEMENT) {
	        if (action.data) {
	            state[action.requestCondition.symbol].flow.data = action.data;
	        } else {
	            var dataInput = action.requestCondition.data;
	            var data = state[action.requestCondition.symbol].flow.data;
	            state[action.requestCondition.symbol].flow.data = ActionTypes.saveOrUpdateElement(data, dataInput);
	        }
	        state[action.requestCondition.symbol].addFormVisible = false;
	        state[action.requestCondition.symbol].dragElementForm = null;
	        state[action.requestCondition.symbol].dragModalData = null;
	        return l_merge({}, state);
	    }
	    if (action.type === ActionTypes.DELETE_ELEMENT) {
	        if (action.data) {
	            state[action.requestCondition.symbol].flow.data = action.data;
	        } else {
	            var data = state[action.requestCondition.symbol].data;
	            var item = action.requestCondition.nowDelete;
	            state[action.requestCondition.symbol].flow.data = ActionTypes.deleteElementInternal(item, data);
	        }
	        state[action.requestCondition.symbol].addFormVisible = false;
	        state[action.requestCondition.symbol].dragElementForm = null;
	        state[action.requestCondition.symbol].dragModalData = null;
	        return l_merge({}, state);
	    }
	    return state;
	}
	
	exports.default = Redux.combineReducers({ main: main });
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! lodash/merge */ 510), __webpack_require__(/*! redux */ 349)))

/***/ },

/***/ 852:
/*!******************************************!*\
  !*** ./js/modules/index/routes/index.js ***!
  \******************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(React, ReactRouter) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	Object.defineProperty(exports, "__esModule", {
	        value: true
	});
	
	var _containers = __webpack_require__(/*! ../containers */ 853);
	
	var Index = _interopRequireWildcard(_containers);
	
	var _dashBoard = __webpack_require__(/*! ../../include/dashBoard/dashBoard.jsx */ 883);
	
	var _dashBoard2 = _interopRequireDefault(_dashBoard);
	
	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }
	
	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }
	
	exports.default = [
	//<ReactRouter.IndexRoute component={Index.dashBoard} />
	React.createElement(
	        ReactRouter.Route,
	        { path: '/(index.html)', component: _dashBoard2.default },
	        React.createElement(ReactRouter.IndexRoute, { component: Index.dashBoard }),
	        React.createElement(ReactRouter.Route, { path: 'dashboard', component: Index.dashBoard }),
	        React.createElement(ReactRouter.Route, { path: 'table', component: Index.table }),
	        React.createElement(ReactRouter.Route, { path: 'chart', component: Index.chart }),
	        React.createElement(ReactRouter.Route, { path: 'form', component: Index.form }),
	        React.createElement(ReactRouter.Route, { path: 'dragdrop', component: Index.dragDrop })
	), React.createElement(
	        ReactRouter.Route,
	        { path: '(**)/(index.html)', component: _dashBoard2.default },
	        React.createElement(ReactRouter.IndexRoute, { component: Index.dashBoard }),
	        React.createElement(ReactRouter.Route, { path: 'dashboard', component: Index.dashBoard }),
	        React.createElement(ReactRouter.Route, { path: 'table', component: Index.table }),
	        React.createElement(ReactRouter.Route, { path: 'chart', component: Index.chart }),
	        React.createElement(ReactRouter.Route, { path: 'form', component: Index.form }),
	        React.createElement(ReactRouter.Route, { path: 'dragdrop', component: Index.dragDrop })
	)];
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! react */ 2), __webpack_require__(/*! react-router */ 776)))

/***/ },

/***/ 853:
/*!**********************************************!*\
  !*** ./js/modules/index/containers/index.js ***!
  \**********************************************/
/***/ function(module, exports, __webpack_require__) {

	/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	Object.defineProperty(exports, "__esModule", {
	  value: true
	});
	
	var _dashBoard = __webpack_require__(/*! ./dashBoard */ 854);
	
	Object.defineProperty(exports, 'dashBoard', {
	  enumerable: true,
	  get: function get() {
	    return _interopRequireDefault(_dashBoard).default;
	  }
	});
	
	var _chart = __webpack_require__(/*! ./chart */ 857);
	
	Object.defineProperty(exports, 'chart', {
	  enumerable: true,
	  get: function get() {
	    return _interopRequireDefault(_chart).default;
	  }
	});
	
	var _table = __webpack_require__(/*! ./table */ 866);
	
	Object.defineProperty(exports, 'table', {
	  enumerable: true,
	  get: function get() {
	    return _interopRequireDefault(_table).default;
	  }
	});
	
	var _form = __webpack_require__(/*! ./form */ 875);
	
	Object.defineProperty(exports, 'form', {
	  enumerable: true,
	  get: function get() {
	    return _interopRequireDefault(_form).default;
	  }
	});
	
	var _dragDrop = __webpack_require__(/*! ./dragDrop */ 879);
	
	Object.defineProperty(exports, 'dragDrop', {
	  enumerable: true,
	  get: function get() {
	    return _interopRequireDefault(_dragDrop).default;
	  }
	});

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }

/***/ },

/***/ 854:
/*!********************************************************!*\
  !*** ./js/modules/index/containers/dashBoard/index.js ***!
  \********************************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(React, Panel, Toast, Modal, Tab, ReactIntl, UtilFun, Layout, ReactRedux) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	
	var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();
	
	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
	
	function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }
	
	function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }
	
	/**
	 * Created by Donghui Huo on 2016/5/11.
	 */
	__webpack_require__(/*! ./index.scss */ 855);
	
	var DashBoardMainBlock = function (_React$Component) {
	    _inherits(DashBoardMainBlock, _React$Component);
	
	    function DashBoardMainBlock(props) {
	        _classCallCheck(this, DashBoardMainBlock);
	
	        return _possibleConstructorReturn(this, (DashBoardMainBlock.__proto__ || Object.getPrototypeOf(DashBoardMainBlock)).call(this, props));
	    }
	
	    _createClass(DashBoardMainBlock, [{
	        key: 'componentWillMount',
	        value: function componentWillMount() {
	            //data init
	        }
	    }, {
	        key: 'componentWillReceiveProps',
	        value: function componentWillReceiveProps(nextProps) {}
	    }, {
	        key: 'render',
	        value: function render() {
	
	            var basicToastData = {
	                content: React.createElement(
	                    'span',
	                    null,
	                    'this is a toast?'
	                ),
	                title: 'check toast?'
	            };
	
	            var basicModalData = {
	                content: React.createElement(
	                    'span',
	                    null,
	                    'test modal?'
	                ),
	                title: 'check something?',
	                closeFun: function closeFun() {
	                    return true;
	                },
	                footerCloseButton: {
	                    visible: true,
	                    title: 'close'
	                },
	                footerContent: React.createElement(
	                    'span',
	                    null,
	                    'test modal'
	                )
	            };
	            var confirmModalData = {
	                content: React.createElement(
	                    'span',
	                    null,
	                    'you can not revert the data'
	                ),
	                title: 'Do you really want to do things like this?',
	                closeFun: function closeFun() {
	                    return true;
	                },
	                footerConfirmButton: {
	                    callback: function callback() {
	                        //console.log('confirm')
	                    },
	                    title: 'Confirm'
	                },
	                footerCloseButton: {
	                    visible: true,
	                    title: 'Cancel'
	                }
	            };
	            var basicTabData = [{
	                id: 1,
	                active: true,
	                title: 'tab1',
	                content: 'content1'
	            }, {
	                id: 2,
	                title: 'tab2',
	                content: 'content2'
	            }, {
	                id: 3,
	                title: 'tab3',
	                children: [{
	                    id: '3-1',
	                    title: 'tab3-1',
	                    content: 'content3-1'
	                }, {
	                    id: '3-2',
	                    title: 'tab3-2',
	                    content: 'content3-2'
	                }]
	            }];
	
	            var columns = [React.createElement(
	                Panel.DefaultPanel,
	                null,
	                React.createElement(
	                    'button',
	                    { className: 'btn btn-primary',
	                        onClick: Toast.createToast.bind(this, basicToastData, 'default') },
	                    'open default toast'
	                )
	            ), React.createElement(
	                Panel.DefaultPanel,
	                null,
	                React.createElement(
	                    'button',
	                    { className: 'btn btn-primary btn-success',
	                        onClick: Toast.createToast.bind(this, basicToastData, 'success') },
	                    'open success toast'
	                )
	            ), React.createElement(
	                Panel.DefaultPanel,
	                null,
	                React.createElement(
	                    'button',
	                    { className: 'btn btn-primary btn-warning',
	                        onClick: Toast.createToast.bind(this, basicToastData, 'warning') },
	                    'open warning toast'
	                )
	            ), React.createElement(
	                Panel.DefaultPanel,
	                null,
	                React.createElement(
	                    'button',
	                    { className: 'btn btn-primary btn-danger',
	                        onClick: Toast.createToast.bind(this, basicToastData, 'error') },
	                    'open error toast'
	                )
	            )];
	            var columnsSecond = [React.createElement(
	                Panel.DefaultPanel,
	                null,
	                React.createElement(
	                    'button',
	                    { className: 'btn btn-primary',
	                        onClick: Modal.createModal.bind(this, { modalValues: basicModalData, type: 'default' }) },
	                    'open default modal'
	                )
	            ), React.createElement(
	                Panel.DefaultPanel,
	                null,
	                React.createElement(
	                    'button',
	                    { className: 'btn btn-primary',
	                        onClick: Modal.createModal.bind(this, { modalValues: basicModalData, type: 'lgModal' }) },
	                    'open large modal'
	                )
	            ), React.createElement(
	                Panel.DefaultPanel,
	                null,
	                React.createElement(
	                    'button',
	                    { className: 'btn btn-primary',
	                        onClick: Modal.createModal.bind(this, { modalValues: basicModalData, type: 'smModal' }) },
	                    'open small modal'
	                )
	            ), React.createElement(
	                Panel.DefaultPanel,
	                null,
	                React.createElement(
	                    'button',
	                    { className: 'btn btn-primary',
	                        onClick: Modal.createModal.bind(this, { modalValues: basicModalData, type: 'message' }) },
	                    'open default message modal'
	                )
	            )];
	            var columnsThird = [React.createElement(
	                Panel.DefaultPanel,
	                null,
	                React.createElement(
	                    'button',
	                    { className: 'btn btn-success',
	                        onClick: Modal.createModal.bind(this, { modalValues: basicModalData, type: 'messageSuccess' }) },
	                    'open success modal'
	                )
	            ), React.createElement(
	                Panel.DefaultPanel,
	                null,
	                React.createElement(
	                    'button',
	                    { className: 'btn btn-warning',
	                        onClick: Modal.createModal.bind(this, { modalValues: basicModalData, type: 'messageWarning' }) },
	                    'open warning modal'
	                )
	            ), React.createElement(
	                Panel.DefaultPanel,
	                null,
	                React.createElement(
	                    'button',
	                    { className: 'btn btn-danger',
	                        onClick: Modal.createModal.bind(this, { modalValues: basicModalData, type: 'messageError' }) },
	                    'open error modal'
	                )
	            ), React.createElement(
	                Panel.DefaultPanel,
	                null,
	                React.createElement(
	                    'button',
	                    { className: 'btn btn-danger',
	                        onClick: Modal.createModal.bind(this, { modalValues: confirmModalData, type: 'messageConfirm' }) },
	                    'open confirm message modal'
	                )
	            )];
	            var columnsFourth = [React.createElement(
	                Panel.DefaultPanel,
	                null,
	                React.createElement(Tab.DefaultTab, { tabValues: basicTabData })
	            ), React.createElement(
	                Panel.DefaultPanel,
	                null,
	                React.createElement(Tab.LeftVerticalTab, { tabValues: basicTabData })
	            ), React.createElement(
	                Panel.DefaultPanel,
	                null,
	                React.createElement(Tab.RightVerticalTab, { tabValues: basicTabData })
	            )];
	            return React.createElement(
	                ReactIntl.IntlProvider,
	                { locale: locale, messages: UtilFun.getIntl('dashBoardMainBlock') },
	                React.createElement(
	                    'div',
	                    null,
	                    React.createElement(Layout.Columns4, { columnValues: columns }),
	                    React.createElement(Layout.Columns4, { columnValues: columnsSecond }),
	                    React.createElement(Layout.Columns4, { columnValues: columnsThird }),
	                    React.createElement(Layout.Columns3, { columnValues: columnsFourth })
	                )
	            );
	        }
	    }]);
	
	    return DashBoardMainBlock;
	}(React.Component);
	
	DashBoardMainBlock.propTypes = {};
	function mapStateToProps(state, ownProps) {
	    return {};
	}
	
	exports.default = ReactRedux.connect(mapStateToProps, {})(DashBoardMainBlock);
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! react */ 2), __webpack_require__(/*! ./js/modules/common/panel/panel.jsx */ 300), __webpack_require__(/*! ./js/modules/common/toast/toast.jsx */ 338), __webpack_require__(/*! ./js/modules/common/modal/modal.jsx */ 267), __webpack_require__(/*! ./js/modules/common/tab/tab.jsx */ 332), __webpack_require__(/*! react-intl */ 270), __webpack_require__(/*! ./js/util/utilFun */ 268), __webpack_require__(/*! ./js/modules/common/layout/layout.jsx */ 264), __webpack_require__(/*! react-redux */ 342)))

/***/ },

/***/ 855:
/*!**********************************************************!*\
  !*** ./js/modules/index/containers/dashBoard/index.scss ***!
  \**********************************************************/
/***/ function(module, exports, __webpack_require__) {

	// style-loader: Adds some css to the DOM by adding a <style> tag
	
	// load the styles
	var content = __webpack_require__(/*! !./../../../../../../~/css-loader!./../../../../../../~/sass-loader!./index.scss */ 856);
	if(typeof content === 'string') content = [[module.id, content, '']];
	// add the styles to the DOM
	var update = __webpack_require__(/*! ./../../../../../../~/style-loader/addStyles.js */ 263)(content, {});
	if(content.locals) module.exports = content.locals;
	// Hot Module Replacement
	if(false) {
		// When the styles change, update the <style> tags
		if(!content.locals) {
			module.hot.accept("!!./../../../../../../node_modules/css-loader/index.js!./../../../../../../node_modules/sass-loader/index.js!./index.scss", function() {
				var newContent = require("!!./../../../../../../node_modules/css-loader/index.js!./../../../../../../node_modules/sass-loader/index.js!./index.scss");
				if(typeof newContent === 'string') newContent = [[module.id, newContent, '']];
				update(newContent);
			});
		}
		// When the module is disposed, remove the <style> tags
		module.hot.dispose(function() { update(); });
	}

/***/ },

/***/ 856:
/*!*******************************************************************************************!*\
  !*** ../~/css-loader!../~/sass-loader!./js/modules/index/containers/dashBoard/index.scss ***!
  \*******************************************************************************************/
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(/*! ./../../../../../../~/css-loader/lib/css-base.js */ 262)();
	// imports
	
	
	// module
	exports.push([module.id, "", ""]);
	
	// exports


/***/ },

/***/ 857:
/*!****************************************************!*\
  !*** ./js/modules/index/containers/chart/index.js ***!
  \****************************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(React, Panel, ReactIntl, UtilFun, Layout, ReactRedux) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	
	var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();
	
	var _chart = __webpack_require__(/*! ../../actions/chart */ 849);
	
	var _LineChart = __webpack_require__(/*! ../../components/charts/LineChart */ 858);
	
	var _LineChart2 = _interopRequireDefault(_LineChart);
	
	var _AreaChart = __webpack_require__(/*! ../../components/charts/AreaChart */ 859);
	
	var _AreaChart2 = _interopRequireDefault(_AreaChart);
	
	var _BarChart = __webpack_require__(/*! ../../components/charts/BarChart */ 860);
	
	var _BarChart2 = _interopRequireDefault(_BarChart);
	
	var _PieChart = __webpack_require__(/*! ../../components/charts/PieChart */ 861);
	
	var _PieChart2 = _interopRequireDefault(_PieChart);
	
	var _ScatterChart = __webpack_require__(/*! ../../components/charts/ScatterChart */ 862);
	
	var _ScatterChart2 = _interopRequireDefault(_ScatterChart);
	
	var _TreemapChart = __webpack_require__(/*! ../../components/charts/TreemapChart */ 863);
	
	var _TreemapChart2 = _interopRequireDefault(_TreemapChart);
	
	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }
	
	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
	
	function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }
	
	function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }
	
	/**
	 * Created by Donghui Huo on 2016/5/11.
	 */
	__webpack_require__(/*! ./index.scss */ 864);
	
	var DashBoardMainBlock = function (_React$Component) {
	    _inherits(DashBoardMainBlock, _React$Component);
	
	    function DashBoardMainBlock(props) {
	        _classCallCheck(this, DashBoardMainBlock);
	
	        return _possibleConstructorReturn(this, (DashBoardMainBlock.__proto__ || Object.getPrototypeOf(DashBoardMainBlock)).call(this, props));
	    }
	
	    _createClass(DashBoardMainBlock, [{
	        key: 'componentWillMount',
	        value: function componentWillMount() {
	            //data init
	            this.props.getDemoLineChartDispatch();
	            this.props.getDemoAreaChartDispatch();
	            this.props.getDemoBarChartDispatch();
	            this.props.getDemoPieChartDispatch();
	            this.props.getDemoScatterChartDispatch();
	            this.props.getDemoTreemapChartDispatch();
	        }
	    }, {
	        key: 'componentWillReceiveProps',
	        value: function componentWillReceiveProps(nextProps) {}
	    }, {
	        key: 'render',
	        value: function render() {
	
	            var columns = [React.createElement(
	                Panel.PanelWithHeader,
	                { panelValues: { title: 'Default Line Chart' } },
	                React.createElement(_LineChart2.default, null)
	            ), React.createElement(
	                Panel.PanelWithHeader,
	                { panelValues: { title: 'Default Area Chart' } },
	                React.createElement(_AreaChart2.default, null)
	            )];
	            var columns2 = [React.createElement(
	                Panel.PanelWithHeader,
	                { panelValues: { title: 'Default Bar Chart' } },
	                React.createElement(_BarChart2.default, null)
	            ), React.createElement(
	                Panel.PanelWithHeader,
	                { panelValues: { title: 'Default Pie Chart' } },
	                React.createElement(_PieChart2.default, null)
	            )];
	
	            var columns3 = [React.createElement(
	                Panel.PanelWithHeader,
	                { panelValues: { title: 'Default Scatter Chart' } },
	                React.createElement(_ScatterChart2.default, null)
	            ), React.createElement(
	                Panel.PanelWithHeader,
	                { panelValues: { title: 'Default Treemap Chart' } },
	                React.createElement(_TreemapChart2.default, null)
	            )];
	
	            return React.createElement(
	                ReactIntl.IntlProvider,
	                { locale: locale, messages: UtilFun.getIntl('dashBoardMainBlock') },
	                React.createElement(
	                    'div',
	                    null,
	                    React.createElement(Layout.Columns2, { columnValues: columns }),
	                    React.createElement(Layout.Columns2, { columnValues: columns2 }),
	                    React.createElement(Layout.Columns2, { columnValues: columns3 })
	                )
	            );
	        }
	    }]);
	
	    return DashBoardMainBlock;
	}(React.Component);
	
	DashBoardMainBlock.propTypes = {
	    getDemoLineChartDispatch: React.PropTypes.func.isRequired,
	    getDemoAreaChartDispatch: React.PropTypes.func.isRequired,
	    getDemoBarChartDispatch: React.PropTypes.func.isRequired,
	    getDemoPieChartDispatch: React.PropTypes.func.isRequired,
	    getDemoScatterChartDispatch: React.PropTypes.func.isRequired,
	    getDemoTreemapChartDispatch: React.PropTypes.func.isRequired
	};
	function mapStateToProps(state, ownProps) {
	    return {};
	}
	
	exports.default = ReactRedux.connect(mapStateToProps, {
	    getDemoLineChartDispatch: _chart.getDemoLineChartDispatch,
	    getDemoAreaChartDispatch: _chart.getDemoAreaChartDispatch,
	    getDemoBarChartDispatch: _chart.getDemoBarChartDispatch,
	    getDemoPieChartDispatch: _chart.getDemoPieChartDispatch,
	    getDemoScatterChartDispatch: _chart.getDemoScatterChartDispatch,
	    getDemoTreemapChartDispatch: _chart.getDemoTreemapChartDispatch
	})(DashBoardMainBlock);
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! react */ 2), __webpack_require__(/*! ./js/modules/common/panel/panel.jsx */ 300), __webpack_require__(/*! react-intl */ 270), __webpack_require__(/*! ./js/util/utilFun */ 268), __webpack_require__(/*! ./js/modules/common/layout/layout.jsx */ 264), __webpack_require__(/*! react-redux */ 342)))

/***/ },

/***/ 858:
/*!*********************************************************!*\
  !*** ./js/modules/index/components/charts/LineChart.js ***!
  \*********************************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(React, ResponsiveCharts, ReactRedux) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	"use strict";
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	
	var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();
	
	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
	
	function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }
	
	function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }
	
	var LineChart = function (_React$Component) {
	    _inherits(LineChart, _React$Component);
	
	    function LineChart() {
	        _classCallCheck(this, LineChart);
	
	        return _possibleConstructorReturn(this, (LineChart.__proto__ || Object.getPrototypeOf(LineChart)).apply(this, arguments));
	    }
	
	    _createClass(LineChart, [{
	        key: "componentWillMount",
	        value: function componentWillMount() {
	            //this.props.getIndexDemoTableDispatch({})
	        }
	    }, {
	        key: "render",
	        value: function render() {
	            return this.props.data ? React.createElement(ResponsiveCharts.ResponsiveLineChart, {
	                legend: true,
	                data: this.props.data,
	                yAxisLabel: "Altitude",
	                xAxisLabel: "Elapsed Time (sec)",
	                domain: { x: [, 6], y: [-10] },
	                gridHorizontal: true
	            }) : null;
	        }
	    }]);
	
	    return LineChart;
	}(React.Component);
	
	LineChart.propTypes = {
	    data: React.PropTypes.array
	};
	
	function mapStateToProps(state, ownProps) {
	    if (state && state.chart && state.chart.demoLineChartData) {
	        var data = state.chart.demoLineChartData.data;
	
	        return { data: data };
	    } else {
	        return {};
	    }
	}
	
	exports.default = ReactRedux.connect(mapStateToProps, {})(LineChart);
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "LineChart.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! react */ 2), __webpack_require__(/*! ./js/modules/common/responsiveCharts/responsiveCharts.jsx */ 304), __webpack_require__(/*! react-redux */ 342)))

/***/ },

/***/ 859:
/*!*********************************************************!*\
  !*** ./js/modules/index/components/charts/AreaChart.js ***!
  \*********************************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(React, ResponsiveCharts, ReactRedux) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	"use strict";
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	
	var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();
	
	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
	
	function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }
	
	function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }
	
	var AreaChart = function (_React$Component) {
	    _inherits(AreaChart, _React$Component);
	
	    function AreaChart() {
	        _classCallCheck(this, AreaChart);
	
	        return _possibleConstructorReturn(this, (AreaChart.__proto__ || Object.getPrototypeOf(AreaChart)).apply(this, arguments));
	    }
	
	    _createClass(AreaChart, [{
	        key: "componentWillMount",
	        value: function componentWillMount() {
	            //this.props.getIndexDemoTableDispatch({})
	        }
	    }, {
	        key: "render",
	        value: function render() {
	            return this.props.data ? React.createElement(ResponsiveCharts.ResponsiveAreaChart, {
	                legend: true,
	                data: this.props.data,
	                xAxisTickInterval: { unit: 'year', interval: 2 },
	                yAxisLabel: "Altitude",
	                xAxisLabel: "Elapsed Time (sec)",
	                xAccessor: function xAccessor(d) {
	                    return new Date(d[0]);
	                },
	                yAccessor: function yAccessor(d) {
	                    return d[1];
	                },
	                domain: { y: [, 60] }
	            }) : null;
	        }
	    }]);
	
	    return AreaChart;
	}(React.Component);
	
	AreaChart.propTypes = {
	    data: React.PropTypes.array
	};
	
	function mapStateToProps(state, ownProps) {
	    if (state && state.chart && state.chart.demoAreaChartData) {
	        var data = state.chart.demoAreaChartData.data;
	
	        return { data: data };
	    } else {
	        return {};
	    }
	}
	
	exports.default = ReactRedux.connect(mapStateToProps, {})(AreaChart);
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "AreaChart.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! react */ 2), __webpack_require__(/*! ./js/modules/common/responsiveCharts/responsiveCharts.jsx */ 304), __webpack_require__(/*! react-redux */ 342)))

/***/ },

/***/ 860:
/*!********************************************************!*\
  !*** ./js/modules/index/components/charts/BarChart.js ***!
  \********************************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(React, ResponsiveCharts, ReactRedux) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	"use strict";
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	
	var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();
	
	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
	
	function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }
	
	function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }
	
	var BarChart = function (_React$Component) {
	    _inherits(BarChart, _React$Component);
	
	    function BarChart() {
	        _classCallCheck(this, BarChart);
	
	        return _possibleConstructorReturn(this, (BarChart.__proto__ || Object.getPrototypeOf(BarChart)).apply(this, arguments));
	    }
	
	    _createClass(BarChart, [{
	        key: "componentWillMount",
	        value: function componentWillMount() {
	            //this.props.getIndexDemoTableDispatch({})
	        }
	    }, {
	        key: "render",
	        value: function render() {
	            return this.props.data ? React.createElement(ResponsiveCharts.ResponsiveBarChart, {
	                legend: true,
	                data: this.props.data,
	                xAxisLabel: "Position",
	                yAxisLabel: "Value"
	            }) : null;
	        }
	    }]);
	
	    return BarChart;
	}(React.Component);
	
	BarChart.propTypes = {
	    data: React.PropTypes.array
	};
	
	function mapStateToProps(state, ownProps) {
	    if (state && state.chart && state.chart.demoBarChartData) {
	        var data = state.chart.demoBarChartData.data;
	
	        return { data: data };
	    } else {
	        return {};
	    }
	}
	
	exports.default = ReactRedux.connect(mapStateToProps, {})(BarChart);
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "BarChart.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! react */ 2), __webpack_require__(/*! ./js/modules/common/responsiveCharts/responsiveCharts.jsx */ 304), __webpack_require__(/*! react-redux */ 342)))

/***/ },

/***/ 861:
/*!********************************************************!*\
  !*** ./js/modules/index/components/charts/PieChart.js ***!
  \********************************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(React, ResponsiveCharts, ReactRedux) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	"use strict";
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	
	var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();
	
	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
	
	function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }
	
	function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }
	
	var PieChart = function (_React$Component) {
	    _inherits(PieChart, _React$Component);
	
	    function PieChart() {
	        _classCallCheck(this, PieChart);
	
	        return _possibleConstructorReturn(this, (PieChart.__proto__ || Object.getPrototypeOf(PieChart)).apply(this, arguments));
	    }
	
	    _createClass(PieChart, [{
	        key: "componentWillMount",
	        value: function componentWillMount() {
	            //this.props.getIndexDemoTableDispatch({})
	        }
	    }, {
	        key: "render",
	        value: function render() {
	            return this.props.data ? React.createElement(ResponsiveCharts.ResponsivePieChart, {
	                data: this.props.data,
	                sectorBorderColor: "white"
	            }) : null;
	        }
	    }]);
	
	    return PieChart;
	}(React.Component);
	
	PieChart.propTypes = {
	    data: React.PropTypes.array
	};
	
	function mapStateToProps(state, ownProps) {
	    if (state && state.chart && state.chart.demoPieChartData) {
	        var data = state.chart.demoPieChartData.data;
	
	        return { data: data };
	    } else {
	        return {};
	    }
	}
	
	exports.default = ReactRedux.connect(mapStateToProps, {})(PieChart);
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "PieChart.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! react */ 2), __webpack_require__(/*! ./js/modules/common/responsiveCharts/responsiveCharts.jsx */ 304), __webpack_require__(/*! react-redux */ 342)))

/***/ },

/***/ 862:
/*!************************************************************!*\
  !*** ./js/modules/index/components/charts/ScatterChart.js ***!
  \************************************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(React, ResponsiveCharts, ReactRedux) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	"use strict";
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	
	var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();
	
	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
	
	function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }
	
	function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }
	
	var ScatterChart = function (_React$Component) {
	    _inherits(ScatterChart, _React$Component);
	
	    function ScatterChart() {
	        _classCallCheck(this, ScatterChart);
	
	        return _possibleConstructorReturn(this, (ScatterChart.__proto__ || Object.getPrototypeOf(ScatterChart)).apply(this, arguments));
	    }
	
	    _createClass(ScatterChart, [{
	        key: "componentWillMount",
	        value: function componentWillMount() {
	            //this.props.getIndexDemoTableDispatch({})
	        }
	    }, {
	        key: "render",
	        value: function render() {
	            return this.props.data ? React.createElement(ResponsiveCharts.ResponsiveScatterChart, {
	                legend: true,
	                data: this.props.data,
	                domain: { x: [-15], y: [-15] }
	            }) : null;
	        }
	    }]);
	
	    return ScatterChart;
	}(React.Component);
	
	ScatterChart.propTypes = {
	    data: React.PropTypes.array
	};
	
	function mapStateToProps(state, ownProps) {
	    if (state && state.chart && state.chart.demoScatterChartData) {
	        var data = state.chart.demoScatterChartData.data;
	
	        return { data: data };
	    } else {
	        return {};
	    }
	}
	
	exports.default = ReactRedux.connect(mapStateToProps, {})(ScatterChart);
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "ScatterChart.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! react */ 2), __webpack_require__(/*! ./js/modules/common/responsiveCharts/responsiveCharts.jsx */ 304), __webpack_require__(/*! react-redux */ 342)))

/***/ },

/***/ 863:
/*!************************************************************!*\
  !*** ./js/modules/index/components/charts/TreemapChart.js ***!
  \************************************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(React, ResponsiveCharts, ReactRedux) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	"use strict";
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	
	var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();
	
	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
	
	function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }
	
	function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }
	
	var TreemapChart = function (_React$Component) {
	    _inherits(TreemapChart, _React$Component);
	
	    function TreemapChart() {
	        _classCallCheck(this, TreemapChart);
	
	        return _possibleConstructorReturn(this, (TreemapChart.__proto__ || Object.getPrototypeOf(TreemapChart)).apply(this, arguments));
	    }
	
	    _createClass(TreemapChart, [{
	        key: "componentWillMount",
	        value: function componentWillMount() {
	            //this.props.getIndexDemoTableDispatch({})
	        }
	    }, {
	        key: "render",
	        value: function render() {
	            return this.props.data ? React.createElement(ResponsiveCharts.ResponsiveTreemap, {
	                legend: true,
	                data: this.props.data,
	                hoverAnimation: true
	            }) : null;
	        }
	    }]);
	
	    return TreemapChart;
	}(React.Component);
	
	TreemapChart.propTypes = {
	    data: React.PropTypes.array
	};
	
	function mapStateToProps(state, ownProps) {
	    if (state && state.chart && state.chart.demoTreemapChartData) {
	        var data = state.chart.demoTreemapChartData.data;
	
	        return { data: data };
	    } else {
	        return {};
	    }
	}
	
	exports.default = ReactRedux.connect(mapStateToProps, {})(TreemapChart);
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "TreemapChart.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! react */ 2), __webpack_require__(/*! ./js/modules/common/responsiveCharts/responsiveCharts.jsx */ 304), __webpack_require__(/*! react-redux */ 342)))

/***/ },

/***/ 864:
/*!******************************************************!*\
  !*** ./js/modules/index/containers/chart/index.scss ***!
  \******************************************************/
/***/ function(module, exports, __webpack_require__) {

	// style-loader: Adds some css to the DOM by adding a <style> tag
	
	// load the styles
	var content = __webpack_require__(/*! !./../../../../../../~/css-loader!./../../../../../../~/sass-loader!./index.scss */ 865);
	if(typeof content === 'string') content = [[module.id, content, '']];
	// add the styles to the DOM
	var update = __webpack_require__(/*! ./../../../../../../~/style-loader/addStyles.js */ 263)(content, {});
	if(content.locals) module.exports = content.locals;
	// Hot Module Replacement
	if(false) {
		// When the styles change, update the <style> tags
		if(!content.locals) {
			module.hot.accept("!!./../../../../../../node_modules/css-loader/index.js!./../../../../../../node_modules/sass-loader/index.js!./index.scss", function() {
				var newContent = require("!!./../../../../../../node_modules/css-loader/index.js!./../../../../../../node_modules/sass-loader/index.js!./index.scss");
				if(typeof newContent === 'string') newContent = [[module.id, newContent, '']];
				update(newContent);
			});
		}
		// When the module is disposed, remove the <style> tags
		module.hot.dispose(function() { update(); });
	}

/***/ },

/***/ 865:
/*!***************************************************************************************!*\
  !*** ../~/css-loader!../~/sass-loader!./js/modules/index/containers/chart/index.scss ***!
  \***************************************************************************************/
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(/*! ./../../../../../../~/css-loader/lib/css-base.js */ 262)();
	// imports
	
	
	// module
	exports.push([module.id, "", ""]);
	
	// exports


/***/ },

/***/ 866:
/*!****************************************************!*\
  !*** ./js/modules/index/containers/table/index.js ***!
  \****************************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(React, Panel, Layout, ReactRedux) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	
	var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();
	
	var _baseTable = __webpack_require__(/*! ../../components/table/baseTable */ 867);
	
	var _baseTable2 = _interopRequireDefault(_baseTable);
	
	var _baseBorderTable = __webpack_require__(/*! ../../components/table/baseBorderTable */ 868);
	
	var _baseBorderTable2 = _interopRequireDefault(_baseBorderTable);
	
	var _baseCondensedTable = __webpack_require__(/*! ../../components/table/baseCondensedTable */ 869);
	
	var _baseCondensedTable2 = _interopRequireDefault(_baseCondensedTable);
	
	var _baseHoverTable = __webpack_require__(/*! ../../components/table/baseHoverTable */ 870);
	
	var _baseHoverTable2 = _interopRequireDefault(_baseHoverTable);
	
	var _baseStripedTable = __webpack_require__(/*! ../../components/table/baseStripedTable */ 871);
	
	var _baseStripedTable2 = _interopRequireDefault(_baseStripedTable);
	
	var _rowEditableTable = __webpack_require__(/*! ../../components/table/rowEditableTable */ 872);
	
	var _rowEditableTable2 = _interopRequireDefault(_rowEditableTable);
	
	var _table = __webpack_require__(/*! ../../actions/table */ 846);
	
	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }
	
	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
	
	function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }
	
	function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }
	
	/**
	 * Created by Donghui Huo on 2016/5/11.
	 */
	__webpack_require__(/*! ./index.scss */ 873);
	
	var TableMainBlock = function (_React$Component) {
	    _inherits(TableMainBlock, _React$Component);
	
	    function TableMainBlock(props) {
	        _classCallCheck(this, TableMainBlock);
	
	        return _possibleConstructorReturn(this, (TableMainBlock.__proto__ || Object.getPrototypeOf(TableMainBlock)).call(this, props));
	    }
	
	    _createClass(TableMainBlock, [{
	        key: 'componentWillMount',
	        value: function componentWillMount() {
	            //data init
	            this.props.getIndexDemoTableDispatch();
	        }
	    }, {
	        key: 'componentWillReceiveProps',
	        value: function componentWillReceiveProps(nextProps) {
	            if (nextProps.demoTableRefresh) {
	                this.props.refreshDemoTableDispatch();
	            }
	        }
	    }, {
	        key: 'render',
	        value: function render() {
	            var columns1 = [React.createElement(
	                Panel.PanelWithHeader,
	                { panelValues: { title: 'Basic default Table' } },
	                React.createElement(_baseTable2.default, null)
	            ), React.createElement(
	                Panel.PanelWithHeader,
	                { panelValues: { title: 'Basic Border Table' } },
	                React.createElement(_baseBorderTable2.default, null)
	            )];
	            var columns2 = [React.createElement(
	                Panel.PanelWithHeader,
	                { panelValues: { title: 'Basic Condensed Table' } },
	                React.createElement(_baseCondensedTable2.default, null)
	            ), React.createElement(
	                Panel.PanelWithHeader,
	                { panelValues: { title: 'Basic Hover Table' } },
	                React.createElement(_baseHoverTable2.default, null)
	            )];
	            var columns3 = [React.createElement(
	                Panel.PanelWithHeader,
	                { panelValues: { title: 'Basic Striped Table' } },
	                React.createElement(_baseStripedTable2.default, null)
	            ), React.createElement(
	                Panel.PanelWithHeader,
	                { panelValues: { title: 'Basic Table' } },
	                React.createElement(
	                    'div',
	                    null,
	                    'to be continue'
	                )
	            )];
	            return React.createElement(
	                'div',
	                null,
	                React.createElement(Layout.Columns2, { columnValues: columns1 }),
	                React.createElement(Layout.Columns2, { columnValues: columns2 }),
	                React.createElement(Layout.Columns2, { columnValues: columns3 }),
	                React.createElement(
	                    Panel.PanelWithHeader,
	                    { panelValues: { title: 'Row Editable Table' } },
	                    React.createElement(_rowEditableTable2.default, null)
	                )
	            );
	        }
	    }]);
	
	    return TableMainBlock;
	}(React.Component);
	
	TableMainBlock.propTypes = {
	    getIndexDemoTableDispatch: React.PropTypes.func.isRequired,
	    refreshDemoTableDispatch: React.PropTypes.func.isRequired,
	    demoTableRefresh: React.PropTypes.bool
	};
	function mapStateToProps(state, ownProps) {
	    var demoTableRefresh = state.table.demoTable.demoTableRefresh;
	
	    return { demoTableRefresh: demoTableRefresh };
	}
	
	exports.default = ReactRedux.connect(mapStateToProps, {
	    getIndexDemoTableDispatch: _table.getIndexDemoTableDispatch,
	    refreshDemoTableDispatch: _table.refreshDemoTableDispatch
	})(TableMainBlock);
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! react */ 2), __webpack_require__(/*! ./js/modules/common/panel/panel.jsx */ 300), __webpack_require__(/*! ./js/modules/common/layout/layout.jsx */ 264), __webpack_require__(/*! react-redux */ 342)))

/***/ },

/***/ 867:
/*!********************************************************!*\
  !*** ./js/modules/index/components/table/baseTable.js ***!
  \********************************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(React, Table, ReactRedux) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	
	var _typeof = typeof Symbol === "function" && typeof Symbol.iterator === "symbol" ? function (obj) { return typeof obj; } : function (obj) { return obj && typeof Symbol === "function" && obj.constructor === Symbol ? "symbol" : typeof obj; };
	
	var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };
	
	var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();
	
	var _table = __webpack_require__(/*! ../../actions/table */ 846);
	
	var _table2 = __webpack_require__(/*! ../../middleware/table */ 847);
	
	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
	
	function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }
	
	function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }
	
	var BaseTable = function (_React$Component) {
	    _inherits(BaseTable, _React$Component);
	
	    function BaseTable() {
	        _classCallCheck(this, BaseTable);
	
	        return _possibleConstructorReturn(this, (BaseTable.__proto__ || Object.getPrototypeOf(BaseTable)).apply(this, arguments));
	    }
	
	    _createClass(BaseTable, [{
	        key: 'componentWillMount',
	        value: function componentWillMount() {
	            //this.props.getIndexDemoTableDispatch({})
	        }
	    }, {
	        key: 'render',
	        value: function render() {
	            return React.createElement(Table.DefaultTable, _extends({ minHeight: 300, tableRules: _table2.demoTableRules }, this.props));
	        }
	    }]);
	
	    return BaseTable;
	}(React.Component);
	
	BaseTable.propTypes = {
	    tableData: React.PropTypes.array
	};
	
	function mapStateToProps(state, ownProps) {
	    if (state && state.table && state.table.demoTable) {
	        var _ret = function () {
	            var _state$table$demoTabl = state.table.demoTable;
	            var demoTableData = _state$table$demoTabl.demoTableData;
	            var keys = _state$table$demoTabl.keys;
	            var totalCount = _state$table$demoTabl.totalCount;
	
	            var tableData = keys.map(function (id) {
	                return demoTableData[id];
	            });
	            return {
	                v: { tableData: tableData, totalCount: totalCount }
	            };
	        }();
	
	        if ((typeof _ret === 'undefined' ? 'undefined' : _typeof(_ret)) === "object") return _ret.v;
	    } else {
	        return {};
	    }
	}
	
	exports.default = ReactRedux.connect(mapStateToProps, {})(BaseTable);
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "baseTable.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! react */ 2), __webpack_require__(/*! ./js/modules/common/table/table.jsx */ 335), __webpack_require__(/*! react-redux */ 342)))

/***/ },

/***/ 868:
/*!**************************************************************!*\
  !*** ./js/modules/index/components/table/baseBorderTable.js ***!
  \**************************************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(React, Table, ReactRedux) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	
	var _typeof = typeof Symbol === "function" && typeof Symbol.iterator === "symbol" ? function (obj) { return typeof obj; } : function (obj) { return obj && typeof Symbol === "function" && obj.constructor === Symbol ? "symbol" : typeof obj; };
	
	var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };
	
	var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();
	
	var _table = __webpack_require__(/*! ../../actions/table */ 846);
	
	var _table2 = __webpack_require__(/*! ../../middleware/table */ 847);
	
	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
	
	function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }
	
	function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }
	
	var BaseTable = function (_React$Component) {
	    _inherits(BaseTable, _React$Component);
	
	    function BaseTable() {
	        _classCallCheck(this, BaseTable);
	
	        return _possibleConstructorReturn(this, (BaseTable.__proto__ || Object.getPrototypeOf(BaseTable)).apply(this, arguments));
	    }
	
	    _createClass(BaseTable, [{
	        key: 'componentWillMount',
	        value: function componentWillMount() {
	            //this.props.getIndexDemoTableDispatch({})
	        }
	    }, {
	        key: 'render',
	        value: function render() {
	            return React.createElement(Table.BorderTable, _extends({ minHeight: 300, tableRules: _table2.demoTableRules }, this.props));
	        }
	    }]);
	
	    return BaseTable;
	}(React.Component);
	
	BaseTable.propTypes = {
	    tableData: React.PropTypes.array
	};
	
	function mapStateToProps(state, ownProps) {
	    if (state && state.table && state.table.demoTable) {
	        var _ret = function () {
	            var _state$table$demoTabl = state.table.demoTable;
	            var demoTableData = _state$table$demoTabl.demoTableData;
	            var keys = _state$table$demoTabl.keys;
	            var totalCount = _state$table$demoTabl.totalCount;
	
	            var tableData = keys.map(function (id) {
	                return demoTableData[id];
	            });
	            return {
	                v: { tableData: tableData, totalCount: totalCount }
	            };
	        }();
	
	        if ((typeof _ret === 'undefined' ? 'undefined' : _typeof(_ret)) === "object") return _ret.v;
	    } else {
	        return {};
	    }
	}
	
	exports.default = ReactRedux.connect(mapStateToProps, {})(BaseTable);
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "baseBorderTable.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! react */ 2), __webpack_require__(/*! ./js/modules/common/table/table.jsx */ 335), __webpack_require__(/*! react-redux */ 342)))

/***/ },

/***/ 869:
/*!*****************************************************************!*\
  !*** ./js/modules/index/components/table/baseCondensedTable.js ***!
  \*****************************************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(React, Table, ReactRedux) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	
	var _typeof = typeof Symbol === "function" && typeof Symbol.iterator === "symbol" ? function (obj) { return typeof obj; } : function (obj) { return obj && typeof Symbol === "function" && obj.constructor === Symbol ? "symbol" : typeof obj; };
	
	var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };
	
	var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();
	
	var _table = __webpack_require__(/*! ../../actions/table */ 846);
	
	var _table2 = __webpack_require__(/*! ../../middleware/table */ 847);
	
	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
	
	function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }
	
	function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }
	
	var BaseTable = function (_React$Component) {
	    _inherits(BaseTable, _React$Component);
	
	    function BaseTable() {
	        _classCallCheck(this, BaseTable);
	
	        return _possibleConstructorReturn(this, (BaseTable.__proto__ || Object.getPrototypeOf(BaseTable)).apply(this, arguments));
	    }
	
	    _createClass(BaseTable, [{
	        key: 'componentWillMount',
	        value: function componentWillMount() {
	            //this.props.getIndexDemoTableDispatch({})
	        }
	    }, {
	        key: 'render',
	        value: function render() {
	            return React.createElement(Table.CondensedTable, _extends({ minHeight: 300, tableRules: _table2.demoTableRules }, this.props));
	        }
	    }]);
	
	    return BaseTable;
	}(React.Component);
	
	BaseTable.propTypes = {
	    tableData: React.PropTypes.array
	};
	
	function mapStateToProps(state, ownProps) {
	    if (state && state.table && state.table.demoTable) {
	        var _ret = function () {
	            var _state$table$demoTabl = state.table.demoTable;
	            var demoTableData = _state$table$demoTabl.demoTableData;
	            var keys = _state$table$demoTabl.keys;
	            var totalCount = _state$table$demoTabl.totalCount;
	
	            var tableData = keys.map(function (id) {
	                return demoTableData[id];
	            });
	            return {
	                v: { tableData: tableData, totalCount: totalCount }
	            };
	        }();
	
	        if ((typeof _ret === 'undefined' ? 'undefined' : _typeof(_ret)) === "object") return _ret.v;
	    } else {
	        return {};
	    }
	}
	
	exports.default = ReactRedux.connect(mapStateToProps, {})(BaseTable);
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "baseCondensedTable.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! react */ 2), __webpack_require__(/*! ./js/modules/common/table/table.jsx */ 335), __webpack_require__(/*! react-redux */ 342)))

/***/ },

/***/ 870:
/*!*************************************************************!*\
  !*** ./js/modules/index/components/table/baseHoverTable.js ***!
  \*************************************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(React, Table, ReactRedux) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	
	var _typeof = typeof Symbol === "function" && typeof Symbol.iterator === "symbol" ? function (obj) { return typeof obj; } : function (obj) { return obj && typeof Symbol === "function" && obj.constructor === Symbol ? "symbol" : typeof obj; };
	
	var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };
	
	var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();
	
	var _table = __webpack_require__(/*! ../../actions/table */ 846);
	
	var _table2 = __webpack_require__(/*! ../../middleware/table */ 847);
	
	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
	
	function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }
	
	function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }
	
	var BaseTable = function (_React$Component) {
	    _inherits(BaseTable, _React$Component);
	
	    function BaseTable() {
	        _classCallCheck(this, BaseTable);
	
	        return _possibleConstructorReturn(this, (BaseTable.__proto__ || Object.getPrototypeOf(BaseTable)).apply(this, arguments));
	    }
	
	    _createClass(BaseTable, [{
	        key: 'componentWillMount',
	        value: function componentWillMount() {
	            //this.props.getIndexDemoTableDispatch({})
	        }
	    }, {
	        key: 'render',
	        value: function render() {
	            return React.createElement(Table.HoverTable, _extends({ minHeight: 300, tableRules: _table2.demoTableRules }, this.props));
	        }
	    }]);
	
	    return BaseTable;
	}(React.Component);
	
	BaseTable.propTypes = {
	    tableData: React.PropTypes.array
	};
	
	function mapStateToProps(state, ownProps) {
	    if (state && state.table && state.table.demoTable) {
	        var _ret = function () {
	            var _state$table$demoTabl = state.table.demoTable;
	            var demoTableData = _state$table$demoTabl.demoTableData;
	            var keys = _state$table$demoTabl.keys;
	            var totalCount = _state$table$demoTabl.totalCount;
	
	            var tableData = keys.map(function (id) {
	                return demoTableData[id];
	            });
	            return {
	                v: { tableData: tableData, totalCount: totalCount }
	            };
	        }();
	
	        if ((typeof _ret === 'undefined' ? 'undefined' : _typeof(_ret)) === "object") return _ret.v;
	    } else {
	        return {};
	    }
	}
	
	exports.default = ReactRedux.connect(mapStateToProps, {})(BaseTable);
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "baseHoverTable.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! react */ 2), __webpack_require__(/*! ./js/modules/common/table/table.jsx */ 335), __webpack_require__(/*! react-redux */ 342)))

/***/ },

/***/ 871:
/*!***************************************************************!*\
  !*** ./js/modules/index/components/table/baseStripedTable.js ***!
  \***************************************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(React, Table, ReactRedux) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	
	var _typeof = typeof Symbol === "function" && typeof Symbol.iterator === "symbol" ? function (obj) { return typeof obj; } : function (obj) { return obj && typeof Symbol === "function" && obj.constructor === Symbol ? "symbol" : typeof obj; };
	
	var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };
	
	var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();
	
	var _table = __webpack_require__(/*! ../../actions/table */ 846);
	
	var _table2 = __webpack_require__(/*! ../../middleware/table */ 847);
	
	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
	
	function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }
	
	function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }
	
	var BaseTable = function (_React$Component) {
	    _inherits(BaseTable, _React$Component);
	
	    function BaseTable() {
	        _classCallCheck(this, BaseTable);
	
	        return _possibleConstructorReturn(this, (BaseTable.__proto__ || Object.getPrototypeOf(BaseTable)).apply(this, arguments));
	    }
	
	    _createClass(BaseTable, [{
	        key: 'componentWillMount',
	        value: function componentWillMount() {
	            //this.props.getIndexDemoTableDispatch({})
	        }
	    }, {
	        key: 'render',
	        value: function render() {
	            return React.createElement(Table.StripedTable, _extends({ minHeight: 300, tableRules: _table2.demoTableRules }, this.props));
	        }
	    }]);
	
	    return BaseTable;
	}(React.Component);
	
	BaseTable.propTypes = {
	    tableData: React.PropTypes.array
	};
	
	function mapStateToProps(state, ownProps) {
	    if (state && state.table && state.table.demoTable) {
	        var _ret = function () {
	            var _state$table$demoTabl = state.table.demoTable;
	            var demoTableData = _state$table$demoTabl.demoTableData;
	            var keys = _state$table$demoTabl.keys;
	            var totalCount = _state$table$demoTabl.totalCount;
	
	            var tableData = keys.map(function (id) {
	                return demoTableData[id];
	            });
	            return {
	                v: { tableData: tableData, totalCount: totalCount }
	            };
	        }();
	
	        if ((typeof _ret === 'undefined' ? 'undefined' : _typeof(_ret)) === "object") return _ret.v;
	    } else {
	        return {};
	    }
	}
	
	exports.default = ReactRedux.connect(mapStateToProps, {})(BaseTable);
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "baseStripedTable.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! react */ 2), __webpack_require__(/*! ./js/modules/common/table/table.jsx */ 335), __webpack_require__(/*! react-redux */ 342)))

/***/ },

/***/ 872:
/*!***************************************************************!*\
  !*** ./js/modules/index/components/table/rowEditableTable.js ***!
  \***************************************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(React, Table, ReactRedux) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	
	var _typeof = typeof Symbol === "function" && typeof Symbol.iterator === "symbol" ? function (obj) { return typeof obj; } : function (obj) { return obj && typeof Symbol === "function" && obj.constructor === Symbol ? "symbol" : typeof obj; };
	
	var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };
	
	var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();
	
	var _table = __webpack_require__(/*! ../../actions/table */ 846);
	
	var _table2 = __webpack_require__(/*! ../../middleware/table */ 847);
	
	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
	
	function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }
	
	function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }
	
	var RowEditableTable = function (_React$Component) {
	    _inherits(RowEditableTable, _React$Component);
	
	    function RowEditableTable() {
	        _classCallCheck(this, RowEditableTable);
	
	        return _possibleConstructorReturn(this, (RowEditableTable.__proto__ || Object.getPrototypeOf(RowEditableTable)).apply(this, arguments));
	    }
	
	    _createClass(RowEditableTable, [{
	        key: 'deleteRow',
	        value: function deleteRow(requestCondition) {
	            this.props.deleteDemoTableDispatch(requestCondition);
	        }
	    }, {
	        key: 'getList',
	        value: function getList(requestCondition) {
	            this.props.getIndexDemoTableDispatch(requestCondition);
	        }
	    }, {
	        key: 'saveRow',
	        value: function saveRow(requestCondition) {
	            this.props.addDemoTableDispatch(requestCondition);
	        }
	    }, {
	        key: 'updateRow',
	        value: function updateRow(requestCondition) {
	            this.props.updateDemoTableDispatch(requestCondition);
	        }
	    }, {
	        key: 'updateColumn',
	        value: function updateColumn(requestCondition) {
	            this.props.updateColumnDemoTableDispatch(requestCondition);
	        }
	    }, {
	        key: 'render',
	        value: function render() {
	            return React.createElement(Table.RowEditableTable, _extends({}, this.props, { tableRules: _table2.demoTableRules,
	                additionalFeature: _table2.rowEditableAdditionalFeature,
	                minHeight: 300, deleteRow: this.deleteRow.bind(this),
	                getList: this.getList.bind(this), saveRow: this.saveRow.bind(this),
	                updateRow: this.updateRow.bind(this), updateColumn: this.updateColumn.bind(this) }));
	        }
	    }]);
	
	    return RowEditableTable;
	}(React.Component);
	
	RowEditableTable.propTypes = {
	    tableData: React.PropTypes.array,
	    totalCount: React.PropTypes.number,
	    getIndexDemoTableDispatch: React.PropTypes.func.isRequired,
	    deleteDemoTableDispatch: React.PropTypes.func.isRequired
	};
	function mapStateToProps(state, ownProps) {
	    if (state && state.table && state.table.demoTable) {
	        var _ret = function () {
	            var _state$table$demoTabl = state.table.demoTable;
	            var demoTableData = _state$table$demoTabl.demoTableData;
	            var keys = _state$table$demoTabl.keys;
	            var totalCount = _state$table$demoTabl.totalCount;
	
	            var tableData = keys.map(function (id) {
	                return demoTableData[id];
	            });
	            return {
	                v: { tableData: tableData, totalCount: totalCount }
	            };
	        }();
	
	        if ((typeof _ret === 'undefined' ? 'undefined' : _typeof(_ret)) === "object") return _ret.v;
	    } else {
	        return {};
	    }
	}
	
	exports.default = ReactRedux.connect(mapStateToProps, {
	    getIndexDemoTableDispatch: _table.getIndexDemoTableDispatch,
	    deleteDemoTableDispatch: _table.deleteDemoTableDispatch,
	    addDemoTableDispatch: _table.addDemoTableDispatch,
	    updateDemoTableDispatch: _table.updateDemoTableDispatch,
	    updateColumnDemoTableDispatch: _table.updateColumnDemoTableDispatch
	})(RowEditableTable);
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "rowEditableTable.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! react */ 2), __webpack_require__(/*! ./js/modules/common/table/table.jsx */ 335), __webpack_require__(/*! react-redux */ 342)))

/***/ },

/***/ 873:
/*!******************************************************!*\
  !*** ./js/modules/index/containers/table/index.scss ***!
  \******************************************************/
/***/ function(module, exports, __webpack_require__) {

	// style-loader: Adds some css to the DOM by adding a <style> tag
	
	// load the styles
	var content = __webpack_require__(/*! !./../../../../../../~/css-loader!./../../../../../../~/sass-loader!./index.scss */ 874);
	if(typeof content === 'string') content = [[module.id, content, '']];
	// add the styles to the DOM
	var update = __webpack_require__(/*! ./../../../../../../~/style-loader/addStyles.js */ 263)(content, {});
	if(content.locals) module.exports = content.locals;
	// Hot Module Replacement
	if(false) {
		// When the styles change, update the <style> tags
		if(!content.locals) {
			module.hot.accept("!!./../../../../../../node_modules/css-loader/index.js!./../../../../../../node_modules/sass-loader/index.js!./index.scss", function() {
				var newContent = require("!!./../../../../../../node_modules/css-loader/index.js!./../../../../../../node_modules/sass-loader/index.js!./index.scss");
				if(typeof newContent === 'string') newContent = [[module.id, newContent, '']];
				update(newContent);
			});
		}
		// When the module is disposed, remove the <style> tags
		module.hot.dispose(function() { update(); });
	}

/***/ },

/***/ 874:
/*!***************************************************************************************!*\
  !*** ../~/css-loader!../~/sass-loader!./js/modules/index/containers/table/index.scss ***!
  \***************************************************************************************/
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(/*! ./../../../../../../~/css-loader/lib/css-base.js */ 262)();
	// imports
	
	
	// module
	exports.push([module.id, "", ""]);
	
	// exports


/***/ },

/***/ 875:
/*!***************************************************!*\
  !*** ./js/modules/index/containers/form/index.js ***!
  \***************************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(React, Panel) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	
	var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();
	
	var _DefaultFormWrapper = __webpack_require__(/*! ../../components/form/DefaultFormWrapper */ 876);
	
	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
	
	function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }
	
	function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }
	
	/**
	 * Created by Donghui Huo on 2016/5/11.
	 */
	__webpack_require__(/*! ./index.scss */ 877);
	
	var FormMainBlock = function (_React$Component) {
	    _inherits(FormMainBlock, _React$Component);
	
	    function FormMainBlock(props) {
	        _classCallCheck(this, FormMainBlock);
	
	        return _possibleConstructorReturn(this, (FormMainBlock.__proto__ || Object.getPrototypeOf(FormMainBlock)).call(this, props));
	    }
	
	    _createClass(FormMainBlock, [{
	        key: 'render',
	        value: function render() {
	            return React.createElement(
	                'div',
	                null,
	                React.createElement(
	                    Panel.PanelWithHeader,
	                    { panelValues: { title: 'Default Form' } },
	                    React.createElement(_DefaultFormWrapper.DefaultFormWrapper, null)
	                ),
	                React.createElement(
	                    Panel.PanelWithHeader,
	                    { panelValues: { title: 'WithOutLabel Form ' } },
	                    React.createElement(_DefaultFormWrapper.NoLabelFormWrapper, null)
	                ),
	                React.createElement(
	                    Panel.PanelWithHeader,
	                    { panelValues: { title: 'Horizontal Form' } },
	                    React.createElement(_DefaultFormWrapper.HorizontalFormWrapper, null)
	                ),
	                React.createElement(
	                    Panel.PanelWithHeader,
	                    { panelValues: { title: 'Inline Form' } },
	                    React.createElement(_DefaultFormWrapper.InlineFormWrapper, null)
	                ),
	                React.createElement(
	                    Panel.PanelWithHeader,
	                    { panelValues: { title: 'Block Form' } },
	                    React.createElement(_DefaultFormWrapper.BlockFormWrapper, null)
	                )
	            );
	        }
	    }]);
	
	    return FormMainBlock;
	}(React.Component);
	
	exports.default = FormMainBlock;
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! react */ 2), __webpack_require__(/*! ./js/modules/common/panel/panel.jsx */ 300)))

/***/ },

/***/ 876:
/*!****************************************************************!*\
  !*** ./js/modules/index/components/form/DefaultFormWrapper.js ***!
  \****************************************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(React, Form) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.BlockFormWrapper = exports.InlineFormWrapper = exports.HorizontalFormWrapper = exports.NoLabelFormWrapper = exports.DefaultFormWrapper = undefined;
	
	var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();
	
	var _actions = __webpack_require__(/*! ../../../common/form/actions */ 363);
	
	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
	
	function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }
	
	function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; } //import {DefaultForm, NoLabelForm, HorizontalForm, InlineForm, BlockForm} from '../../../common/form/form.jsx'
	
	
	//let url = 'demoData/formData/basicForm.json'
	var url = 'http://localhost:8081/userclient/oauth2client/test';
	var callback = function callback(data) {
	    //console.log('the data:' + data)
	};
	var initRule = {
	    structure: [{
	
	        name: 'testText',
	        defaultValue: 'not null',
	        label: 'TestText',
	        type: 'text',
	        placeholder: 'give some words',
	        required: true,
	        validateRules: [{ name: _actions.VALIDATE_RULE.REQUIRED_VALIDATE.name }]
	    }, {
	        name: 'testNum',
	        defaultValue: '1',
	        label: 'TestNum',
	        type: 'number',
	        placeholder: 'shall be just number',
	        required: true,
	        validateRules: [{ name: 'custom_validate', validateRegex: '^(-?\\d+)(\\.\\d+)?$', errorMsg: '必须为数字' }]
	    }, {
	        name: 'testDate',
	        defaultValue: '2011-11-11',
	        label: 'TestDate',
	        type: 'date',
	        placeholder: 'shall be just date',
	        dateFormat: 'YYYY-MM-DD',
	        required: true,
	        validateRules: [{ name: _actions.VALIDATE_RULE.REQUIRED_VALIDATE.name, errorMsg: '不能为空' }]
	    }, {
	        name: 'testDateRange',
	        defaultStartValue: '2011/11/11',
	        defaultEndValue: '2011/11/15',
	        label: 'TestDateRange',
	        type: 'daterange',
	        placeholder: 'shall be just date',
	        required: true,
	        validateRules: [[{
	            name: _actions.VALIDATE_RULE.REQUIRED_VALIDATE.name,
	            errorMsg: '起始时间不能为空'
	        }], [{ name: _actions.VALIDATE_RULE.REQUIRED_VALIDATE.name, errorMsg: '结束时间不能为空' }]]
	    }, {
	        name: 'testFile',
	        label: 'TestFile1',
	        type: 'file',
	        placeholder: 'shall be just file',
	        required: true,
	        validateRules: [{ name: _actions.VALIDATE_RULE.REQUIRED_VALIDATE.name, errorMsg: '不能为空' }]
	    }, {
	        name: 'testTextarea',
	        label: 'TestTextarea',
	        type: 'textarea',
	        placeholder: 'shall be just textarea',
	        required: true,
	        rows: 10,
	        defaultValue: '<div>text</div>',
	        validateRules: [{ name: _actions.VALIDATE_RULE.REQUIRED_VALIDATE.name, errorMsg: '不能为空' }]
	    }, {
	        name: 'testCheckbox',
	        items: [{ value: 1, label: 'label1' }, { value: 2, label: 'label2' }],
	        label: 'TestCheckBox',
	        type: 'checkbox',
	        dataType: "number",
	        required: true,
	        validateRules: [{ name: _actions.VALIDATE_RULE.REQUIRED_VALIDATE.name, errorMsg: '不能为空' }]
	    }, {
	        name: 'testRadio',
	        items: [{ value: 1, label: 'label1' }, { value: 2, label: 'label2' }],
	        label: 'TestRadio',
	        type: 'radio',
	        required: true,
	        dataType: "number",
	        validateRules: [{ name: _actions.VALIDATE_RULE.REQUIRED_VALIDATE.name, errorMsg: '不能为空' }]
	    }, {
	        name: 'testPassword',
	        label: 'TestPassword',
	        type: 'password',
	        validateRules: [{
	            name: 'custom_validate',
	            validateRegex: '^(?![a-zA-z]+$)(?!\\d+$)(?![!@#$%^&*]+$)[a-zA-Z\\d!@#$%^&*]{6,15}$',
	            errorMsg: '至少包含数字，字母以及特殊字符【!@#$%^&*】中任意两种,并在6-15字符之间'
	        }]
	    }, {
	        name: 'testHidden',
	        type: 'hidden',
	        defaultValue: 'you can not see it'
	    }, {
	        label: 'TestEmail',
	        name: 'testEmail',
	        type: 'email',
	        defaultValue: 'a@a.com',
	        validateRules: [{
	            name: 'custom_validate',
	            validateRegex: '^([\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+)$',
	            errorMsg: '只能为电子邮件'
	        }]
	    }, {
	        name: 'testSelect',
	        label: 'Test Select',
	        type: 'select',
	        items: [{ label: 'select 1', value: 'select1' }, { label: 'select 2', value: 'select2' }],
	        required: true,
	        validateRules: [{ name: _actions.VALIDATE_RULE.REQUIRED_VALIDATE.name, errorMsg: '不能为空' }]
	    }],
	    submit: { label: '保存' },
	    reset: { label: '重置' },
	    actions: [{ label: '删除', extraClassName: 'btn-danger' }]
	};
	
	var initBlockRule = {
	    structure: [[{
	        name: 'testText',
	        defaultValue: 'not null',
	        label: 'TestText',
	        type: 'text',
	        placeholder: 'give some words',
	        required: true,
	        validateRules: [{ name: _actions.VALIDATE_RULE.REQUIRED_VALIDATE.name, errorMsg: '不能为空' }]
	    }, {
	        name: 'testNum',
	        defaultValue: '1',
	        label: 'TestNum',
	        type: 'number',
	        placeholder: 'shall be just number',
	        required: true,
	        validateRules: [{ name: 'custom_validate', validateRegex: '^(-?\\d+)(\\.\\d+)?$', errorMsg: '必须为数字' }]
	    }, {
	        name: 'testCheckbox',
	        defaultValue: [1, 2],
	        items: [{ value: 1, label: 'label1' }, { value: 2, label: 'label2' }],
	        label: 'TestCheckBox',
	        type: 'checkbox',
	        dataType: "number",
	        required: true,
	        validateRules: [{ name: _actions.VALIDATE_RULE.REQUIRED_VALIDATE.name, errorMsg: '不能为空' }]
	    }, {
	        name: 'testFile',
	        label: 'TestFile1',
	        type: 'file',
	        placeholder: 'shall be just file',
	        required: false,
	        validateRules: [{ name: _actions.VALIDATE_RULE.REQUIRED_VALIDATE.name, errorMsg: '不能为空' }]
	    }, {
	        name: 'testTextarea',
	        label: 'TestTextarea',
	        type: 'textarea',
	        placeholder: 'shall be just textarea',
	        required: true,
	        rows: 10,
	        defaultValue: '<div>text</div>',
	        validateRules: [{ name: _actions.VALIDATE_RULE.REQUIRED_VALIDATE.name, errorMsg: '不能为空' }]
	    }], [{
	        name: 'testSelect',
	        label: 'Test Select',
	        type: 'select',
	        defaultValue: 'select2',
	        items: [{ label: 'select 1', value: 'select1' }, { label: 'select 2', value: 'select2' }],
	        required: true,
	        validateRules: [{ name: _actions.VALIDATE_RULE.REQUIRED_VALIDATE.name, errorMsg: '不能为空' }]
	    }, {
	        name: 'testRadio',
	        items: [{ value: 1, label: 'label1' }, { value: 2, label: 'label2' }],
	        dataType: "number",
	        label: 'TestRadio',
	        type: 'radio',
	        required: true,
	        validateRules: [{ name: _actions.VALIDATE_RULE.REQUIRED_VALIDATE.name, errorMsg: '不能为空' }]
	    }, {
	        name: 'testPassword',
	        label: 'TestPassword',
	        type: 'password',
	        validateRules: [{
	            name: 'custom_validate',
	            validateRegex: '^(?![a-zA-z]+$)(?!\\d+$)(?![!@#$%^&*]+$)[a-zA-Z\\d!@#$%^&*]{6,15}$',
	            errorMsg: '至少包含数字，字母以及特殊字符【!@#$%^&*】中任意两种,并在6-15字符之间'
	        }]
	    }, {
	        name: 'testHidden',
	        type: 'hidden',
	        defaultValue: 'you can not see it'
	    }, {
	        label: 'TestEmail',
	        name: 'testEmail',
	        type: 'email',
	        defaultValue: 'a@a.com',
	        validateRules: [{
	            name: 'custom_validate',
	            validateRegex: '^([\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+)$',
	            errorMsg: '只能为电子邮件'
	        }]
	    }], [{
	        name: 'testDate',
	        defaultValue: '2011/11/11',
	        label: 'TestDate',
	        type: 'date',
	        placeholder: 'shall be just date',
	        required: true,
	        validateRules: [{ name: _actions.VALIDATE_RULE.REQUIRED_VALIDATE.name, errorMsg: '不能为空' }]
	    }, {
	        name: 'testDateRange',
	        defaultStartValue: '2011/11/11',
	        defaultEndValue: '2011/11/15',
	        label: 'TestDateRange',
	        type: 'daterange',
	        placeholder: 'shall be just date',
	        required: true,
	        validateRules: [[{
	            name: _actions.VALIDATE_RULE.REQUIRED_VALIDATE.name,
	            errorMsg: '起始时间不能为空'
	        }], [{ name: _actions.VALIDATE_RULE.REQUIRED_VALIDATE.name, errorMsg: '结束时间不能为空' }]]
	    }]],
	    submit: { label: '保存' },
	    reset: { label: '重置' },
	    actions: [{ extraClassName: 'btn-danger', label: '删除' }]
	};
	
	var DefaultFormWrapper = exports.DefaultFormWrapper = function (_React$Component) {
	    _inherits(DefaultFormWrapper, _React$Component);
	
	    function DefaultFormWrapper() {
	        _classCallCheck(this, DefaultFormWrapper);
	
	        return _possibleConstructorReturn(this, (DefaultFormWrapper.__proto__ || Object.getPrototypeOf(DefaultFormWrapper)).apply(this, arguments));
	    }
	
	    _createClass(DefaultFormWrapper, [{
	        key: 'render',
	        value: function render() {
	            var extraClassName = 'test-default-form';
	
	            var symbol = 'form-' + 'index-demo-default';
	            return React.createElement(Form.DefaultForm, { extraClassName: extraClassName, url: url, callback: callback, initRule: initRule,
	                symbol: symbol });
	        }
	    }]);
	
	    return DefaultFormWrapper;
	}(React.Component);
	
	var NoLabelFormWrapper = exports.NoLabelFormWrapper = function (_React$Component2) {
	    _inherits(NoLabelFormWrapper, _React$Component2);
	
	    function NoLabelFormWrapper() {
	        _classCallCheck(this, NoLabelFormWrapper);
	
	        return _possibleConstructorReturn(this, (NoLabelFormWrapper.__proto__ || Object.getPrototypeOf(NoLabelFormWrapper)).apply(this, arguments));
	    }
	
	    _createClass(NoLabelFormWrapper, [{
	        key: 'render',
	        value: function render() {
	            var extraClassName = 'test-nolabel-form';
	            var symbol = 'form-' + 'index-demo-nolabel';
	            return React.createElement(Form.NoLabelForm, { extraClassName: extraClassName, url: url, callback: callback, initRule: initRule,
	                symbol: symbol });
	        }
	    }]);
	
	    return NoLabelFormWrapper;
	}(React.Component);
	
	var HorizontalFormWrapper = exports.HorizontalFormWrapper = function (_React$Component3) {
	    _inherits(HorizontalFormWrapper, _React$Component3);
	
	    function HorizontalFormWrapper() {
	        _classCallCheck(this, HorizontalFormWrapper);
	
	        return _possibleConstructorReturn(this, (HorizontalFormWrapper.__proto__ || Object.getPrototypeOf(HorizontalFormWrapper)).apply(this, arguments));
	    }
	
	    _createClass(HorizontalFormWrapper, [{
	        key: 'render',
	        value: function render() {
	            var extraClassName = 'test-horizontal-form';
	            var symbol = 'form-' + 'index-demo-horizontal';
	            return React.createElement(Form.HorizontalForm, { extraClassName: extraClassName, url: url, callback: callback, initRule: initRule,
	                symbol: symbol });
	        }
	    }]);
	
	    return HorizontalFormWrapper;
	}(React.Component);
	
	var InlineFormWrapper = exports.InlineFormWrapper = function (_React$Component4) {
	    _inherits(InlineFormWrapper, _React$Component4);
	
	    function InlineFormWrapper() {
	        _classCallCheck(this, InlineFormWrapper);
	
	        return _possibleConstructorReturn(this, (InlineFormWrapper.__proto__ || Object.getPrototypeOf(InlineFormWrapper)).apply(this, arguments));
	    }
	
	    _createClass(InlineFormWrapper, [{
	        key: 'render',
	        value: function render() {
	            var extraClassName = 'test-inline-form';
	            var symbol = 'form-' + 'index-demo-inline';
	            return React.createElement(Form.InlineForm, { extraClassName: extraClassName, url: url, callback: callback, initRule: initRule,
	                symbol: symbol });
	        }
	    }]);
	
	    return InlineFormWrapper;
	}(React.Component);
	
	var BlockFormWrapper = exports.BlockFormWrapper = function (_React$Component5) {
	    _inherits(BlockFormWrapper, _React$Component5);
	
	    function BlockFormWrapper() {
	        _classCallCheck(this, BlockFormWrapper);
	
	        return _possibleConstructorReturn(this, (BlockFormWrapper.__proto__ || Object.getPrototypeOf(BlockFormWrapper)).apply(this, arguments));
	    }
	
	    _createClass(BlockFormWrapper, [{
	        key: 'render',
	        value: function render() {
	            var extraClassName = 'test-block-form';
	            var symbol = 'form-' + 'index-demo-block';
	            return React.createElement(Form.BlockForm, { extraClassName: extraClassName, url: url, callback: callback, initRule: initBlockRule,
	                symbol: symbol });
	        }
	    }]);
	
	    return BlockFormWrapper;
	}(React.Component);
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "DefaultFormWrapper.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! react */ 2), __webpack_require__(/*! ./js/modules/common/form/form.jsx */ 341)))

/***/ },

/***/ 877:
/*!*****************************************************!*\
  !*** ./js/modules/index/containers/form/index.scss ***!
  \*****************************************************/
/***/ function(module, exports, __webpack_require__) {

	// style-loader: Adds some css to the DOM by adding a <style> tag
	
	// load the styles
	var content = __webpack_require__(/*! !./../../../../../../~/css-loader!./../../../../../../~/sass-loader!./index.scss */ 878);
	if(typeof content === 'string') content = [[module.id, content, '']];
	// add the styles to the DOM
	var update = __webpack_require__(/*! ./../../../../../../~/style-loader/addStyles.js */ 263)(content, {});
	if(content.locals) module.exports = content.locals;
	// Hot Module Replacement
	if(false) {
		// When the styles change, update the <style> tags
		if(!content.locals) {
			module.hot.accept("!!./../../../../../../node_modules/css-loader/index.js!./../../../../../../node_modules/sass-loader/index.js!./index.scss", function() {
				var newContent = require("!!./../../../../../../node_modules/css-loader/index.js!./../../../../../../node_modules/sass-loader/index.js!./index.scss");
				if(typeof newContent === 'string') newContent = [[module.id, newContent, '']];
				update(newContent);
			});
		}
		// When the module is disposed, remove the <style> tags
		module.hot.dispose(function() { update(); });
	}

/***/ },

/***/ 878:
/*!**************************************************************************************!*\
  !*** ../~/css-loader!../~/sass-loader!./js/modules/index/containers/form/index.scss ***!
  \**************************************************************************************/
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(/*! ./../../../../../../~/css-loader/lib/css-base.js */ 262)();
	// imports
	
	
	// module
	exports.push([module.id, "", ""]);
	
	// exports


/***/ },

/***/ 879:
/*!*******************************************************!*\
  !*** ./js/modules/index/containers/dragDrop/index.js ***!
  \*******************************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(React, Panel) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	
	var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();
	
	var _DefaultDragDropWrapper = __webpack_require__(/*! ../../components/dragDrop/DefaultDragDropWrapper */ 880);
	
	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
	
	function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }
	
	function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }
	
	/**
	 * Created by Donghui Huo on 2016/5/11.
	 */
	__webpack_require__(/*! ./index.scss */ 881);
	
	var DragDropMainBlock = function (_React$Component) {
	    _inherits(DragDropMainBlock, _React$Component);
	
	    function DragDropMainBlock(props) {
	        _classCallCheck(this, DragDropMainBlock);
	
	        return _possibleConstructorReturn(this, (DragDropMainBlock.__proto__ || Object.getPrototypeOf(DragDropMainBlock)).call(this, props));
	    }
	
	    _createClass(DragDropMainBlock, [{
	        key: 'render',
	        value: function render() {
	            return React.createElement(
	                'div',
	                null,
	                React.createElement(
	                    Panel.PanelWithHeader,
	                    { panelValues: { title: 'Default Test DragAndDrop' } },
	                    React.createElement(_DefaultDragDropWrapper.DefaultDragDropWrapper, null)
	                ),
	                React.createElement(
	                    Panel.PanelWithHeader,
	                    { panelValues: { title: 'Default Test DragAndDrop With Data Init' } },
	                    React.createElement(_DefaultDragDropWrapper.UpdateDragDropWrapper, null)
	                ),
	                React.createElement(
	                    Panel.PanelWithHeader,
	                    { panelValues: { title: 'Positions Test DragAndDrop With Data Init' } },
	                    React.createElement(_DefaultDragDropWrapper.PositionsDragDropWrapper, null)
	                )
	            );
	        }
	    }]);
	
	    return DragDropMainBlock;
	}(React.Component);
	
	exports.default = DragDropMainBlock;
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! react */ 2), __webpack_require__(/*! ./js/modules/common/panel/panel.jsx */ 300)))

/***/ },

/***/ 880:
/*!************************************************************************!*\
  !*** ./js/modules/index/components/dragDrop/DefaultDragDropWrapper.js ***!
  \************************************************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(React, DragDrop) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	"use strict";
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	
	var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();
	
	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
	
	function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }
	
	function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }
	
	var DefaultDragDropWrapper = exports.DefaultDragDropWrapper = function (_React$Component) {
	    _inherits(DefaultDragDropWrapper, _React$Component);
	
	    function DefaultDragDropWrapper() {
	        _classCallCheck(this, DefaultDragDropWrapper);
	
	        return _possibleConstructorReturn(this, (DefaultDragDropWrapper.__proto__ || Object.getPrototypeOf(DefaultDragDropWrapper)).apply(this, arguments));
	    }
	
	    _createClass(DefaultDragDropWrapper, [{
	        key: "render",
	        value: function render() {
	            return React.createElement(
	                "div",
	                null,
	                React.createElement(DragDrop.DragDrop, { symbol: "test_default_flow", type: "actions"
	                    // initUrl={"demoData/dragDrop/workGroupSample.json"}
	                    , rolesUrl: "demoData/dragDrop/roles.json",
	                    saveUrl: "demoData/dragDrop/save.json",
	                    positionsUrl: "demoData/dragDrop/positions.json" })
	            );
	        }
	    }]);
	
	    return DefaultDragDropWrapper;
	}(React.Component);
	
	var UpdateDragDropWrapper = exports.UpdateDragDropWrapper = function (_React$Component2) {
	    _inherits(UpdateDragDropWrapper, _React$Component2);
	
	    function UpdateDragDropWrapper() {
	        _classCallCheck(this, UpdateDragDropWrapper);
	
	        return _possibleConstructorReturn(this, (UpdateDragDropWrapper.__proto__ || Object.getPrototypeOf(UpdateDragDropWrapper)).apply(this, arguments));
	    }
	
	    _createClass(UpdateDragDropWrapper, [{
	        key: "render",
	        value: function render() {
	            return React.createElement(
	                "div",
	                null,
	                React.createElement(DragDrop.DragDrop, { symbol: "test_default_flow_update", type: "actions",
	                    initUrl: "demoData/dragDrop/workGroupSample.json",
	                    rolesUrl: "demoData/dragDrop/roles.json",
	                    saveUrl: "demoData/dragDrop/update.json",
	                    positionsUrl: "demoData/dragDrop/positions.json" })
	            );
	        }
	    }]);
	
	    return UpdateDragDropWrapper;
	}(React.Component);
	
	var PositionsDragDropWrapper = exports.PositionsDragDropWrapper = function (_React$Component3) {
	    _inherits(PositionsDragDropWrapper, _React$Component3);
	
	    function PositionsDragDropWrapper() {
	        _classCallCheck(this, PositionsDragDropWrapper);
	
	        return _possibleConstructorReturn(this, (PositionsDragDropWrapper.__proto__ || Object.getPrototypeOf(PositionsDragDropWrapper)).apply(this, arguments));
	    }
	
	    _createClass(PositionsDragDropWrapper, [{
	        key: "render",
	        value: function render() {
	            return React.createElement(
	                "div",
	                null,
	                React.createElement(DragDrop.DragDrop, { symbol: "test_default_flow_position", type: "positions",
	                    initUrl: "demoData/dragDrop/workGroupSamplePositions.json",
	                    saveUrl: "demoData/dragDrop/update.json",
	                    positionsUrl: "demoData/dragDrop/positions.json" })
	            );
	        }
	    }]);
	
	    return PositionsDragDropWrapper;
	}(React.Component);
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "DefaultDragDropWrapper.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! react */ 2), __webpack_require__(/*! ./js/modules/common/dragDrop/dragDrop.jsx */ 489)))

/***/ },

/***/ 881:
/*!*********************************************************!*\
  !*** ./js/modules/index/containers/dragDrop/index.scss ***!
  \*********************************************************/
/***/ function(module, exports, __webpack_require__) {

	// style-loader: Adds some css to the DOM by adding a <style> tag
	
	// load the styles
	var content = __webpack_require__(/*! !./../../../../../../~/css-loader!./../../../../../../~/sass-loader!./index.scss */ 882);
	if(typeof content === 'string') content = [[module.id, content, '']];
	// add the styles to the DOM
	var update = __webpack_require__(/*! ./../../../../../../~/style-loader/addStyles.js */ 263)(content, {});
	if(content.locals) module.exports = content.locals;
	// Hot Module Replacement
	if(false) {
		// When the styles change, update the <style> tags
		if(!content.locals) {
			module.hot.accept("!!./../../../../../../node_modules/css-loader/index.js!./../../../../../../node_modules/sass-loader/index.js!./index.scss", function() {
				var newContent = require("!!./../../../../../../node_modules/css-loader/index.js!./../../../../../../node_modules/sass-loader/index.js!./index.scss");
				if(typeof newContent === 'string') newContent = [[module.id, newContent, '']];
				update(newContent);
			});
		}
		// When the module is disposed, remove the <style> tags
		module.hot.dispose(function() { update(); });
	}

/***/ },

/***/ 882:
/*!******************************************************************************************!*\
  !*** ../~/css-loader!../~/sass-loader!./js/modules/index/containers/dragDrop/index.scss ***!
  \******************************************************************************************/
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(/*! ./../../../../../../~/css-loader/lib/css-base.js */ 262)();
	// imports
	
	
	// module
	exports.push([module.id, "", ""]);
	
	// exports


/***/ },

/***/ 883:
/*!****************************************************!*\
  !*** ./js/modules/include/dashBoard/dashBoard.jsx ***!
  \****************************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(React, ReactIntl, UtilFun, ReactRedux) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	
	var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();
	
	var _actions = __webpack_require__(/*! ./actions */ 841);
	
	var _dashBoardTop = __webpack_require__(/*! ./dashBoardTop/dashBoardTop.jsx */ 884);
	
	var _dashBoardTop2 = _interopRequireDefault(_dashBoardTop);
	
	var _dashBoardLeftNav = __webpack_require__(/*! ./dashBoardLeftNav/dashBoardLeftNav.jsx */ 888);
	
	var _dashBoardLeftNav2 = _interopRequireDefault(_dashBoardLeftNav);
	
	var _dashBoardMain = __webpack_require__(/*! ./dashBoardMain/dashBoardMain.jsx */ 891);
	
	var _dashBoardMain2 = _interopRequireDefault(_dashBoardMain);
	
	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }
	
	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
	
	function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }
	
	function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }
	
	/**
	 * Created by Donghui Huo on 2016/5/10.
	 */
	__webpack_require__(/*! ./dashBoard.scss */ 896);
	
	var DashBoardBlock = function (_React$Component) {
	    _inherits(DashBoardBlock, _React$Component);
	
	    function DashBoardBlock(props) {
	        _classCallCheck(this, DashBoardBlock);
	
	        return _possibleConstructorReturn(this, (DashBoardBlock.__proto__ || Object.getPrototypeOf(DashBoardBlock)).call(this, props));
	    }
	
	    _createClass(DashBoardBlock, [{
	        key: 'componentWillMount',
	        value: function componentWillMount() {
	            //data init
	            this.props.getLeftMenuDispatch();
	        }
	    }, {
	        key: 'render',
	        value: function render() {
	
	            return React.createElement(
	                ReactIntl.IntlProvider,
	                { locale: locale, messages: UtilFun.getIntl('dashBoard', 'dashBoardMainBlock') },
	                React.createElement(
	                    'div',
	                    { style: { 'height': '100%' } },
	                    React.createElement(_dashBoardLeftNav2.default, this.props),
	                    React.createElement(_dashBoardTop2.default, this.props),
	                    React.createElement(_dashBoardMain2.default, this.props)
	                )
	            );
	        }
	    }]);
	
	    return DashBoardBlock;
	}(React.Component);
	
	function mapStateToProps(state, ownProps) {
	    return {};
	}
	
	DashBoardBlock.propTypes = {
	    getLeftMenuDispatch: React.PropTypes.func.isRequired,
	    leftMenuCollapseChange: React.PropTypes.func.isRequired,
	    leftMenuSelectedChange: React.PropTypes.func.isRequired,
	    collapse: React.PropTypes.bool,
	    data: React.PropTypes.array,
	    selectedUrl: React.PropTypes.string
	};
	
	function mapStateToProps(state, ownProps) {
	    if (state && state.dashBoardFramework && state.dashBoardFramework.leftMenuData) {
	        var _state$dashBoardFrame = state.dashBoardFramework.leftMenuData;
	        var data = _state$dashBoardFrame.data;
	        var collapse = _state$dashBoardFrame.collapse;
	        var selectedUrl = _state$dashBoardFrame.selectedUrl;
	
	        return { leftMenu: { data: data, collapse: collapse, selectedUrl: selectedUrl } };
	    } else {
	        return { leftMenu: {} };
	    }
	}
	
	exports.default = ReactRedux.connect(mapStateToProps, { getLeftMenuDispatch: _actions.getLeftMenuDispatch, leftMenuCollapseChange: _actions.leftMenuCollapseChange, leftMenuSelectedChange: _actions.leftMenuSelectedChange })(DashBoardBlock);
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "dashBoard.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! react */ 2), __webpack_require__(/*! react-intl */ 270), __webpack_require__(/*! ./js/util/utilFun */ 268), __webpack_require__(/*! react-redux */ 342)))

/***/ },

/***/ 884:
/*!********************************************************************!*\
  !*** ./js/modules/include/dashBoard/dashBoardTop/dashBoardTop.jsx ***!
  \********************************************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(React, ReactIntl) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	
	var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();
	
	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
	
	function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }
	
	function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }
	
	/**
	 * Created by Donghui Huo on 2016/5/10.
	 */
	__webpack_require__(/*! ./dashBoardTop.scss */ 885);
	
	var DashboardTop = function (_React$Component) {
	    _inherits(DashboardTop, _React$Component);
	
	    function DashboardTop(props) {
	        _classCallCheck(this, DashboardTop);
	
	        return _possibleConstructorReturn(this, (DashboardTop.__proto__ || Object.getPrototypeOf(DashboardTop)).call(this, props));
	    }
	
	    _createClass(DashboardTop, [{
	        key: 'onClick',
	        value: function onClick(e) {
	            var sidebar = document.querySelector('.al-sidebar');
	            var mainContent = document.querySelector('main');
	            if (sidebar) {
	                if (sidebar.classList.contains('collapse') || sidebar.clientWidth < 100) {
	                    this.props.leftMenuCollapseChange({ collapse: false });
	                } else {
	                    this.props.leftMenuCollapseChange({ collapse: true });
	                }
	            }
	            return false;
	        }
	    }, {
	        key: 'render',
	        value: function render() {
	            return React.createElement(
	                'div',
	                { className: 'page-top clearfix' },
	                React.createElement(
	                    'a',
	                    { href: '#', className: 'al-logo clearfix' },
	                    React.createElement(
	                        'span',
	                        null,
	                        globalProps['app.name']
	                    ),
	                    globalProps['app.adminPlatform']
	                ),
	                React.createElement('a', { href: '#', className: 'collapse-menu-link', onClick: this.onClick.bind(this) }),
	                React.createElement(
	                    'div',
	                    { className: 'search' },
	                    React.createElement('i', { className: 'ion-ios-search-strong' }),
	                    React.createElement('input', { id: 'searchInput', type: 'text',
	                        placeholder: this.props.intl.formatMessage({ id: 'dashBoard.searchPlaceHolder' }) })
	                ),
	                React.createElement(
	                    'div',
	                    { className: 'user-profile clearfix' },
	                    React.createElement(
	                        'div',
	                        { className: 'al-user-profile dropdown' },
	                        React.createElement(
	                            'a',
	                            { className: 'profile-toggle-link dropdown-toggle' },
	                            React.createElement('img', { src: __webpack_require__(/*! ../../../../../assets/images/profile/Nasta.png */ 887) })
	                        )
	                    ),
	                    React.createElement(
	                        'ul',
	                        { className: 'al-msg-center clearfix' },
	                        React.createElement(
	                            'li',
	                            { className: 'dropdown' },
	                            React.createElement(
	                                'a',
	                                { href: '', className: 'dropdown-toggle' },
	                                React.createElement('i', { className: 'fa fa-bell-o' }),
	                                React.createElement(
	                                    'span',
	                                    null,
	                                    '5'
	                                ),
	                                React.createElement('div', { className: 'notification-ring' })
	                            )
	                        ),
	                        React.createElement(
	                            'li',
	                            { className: 'dropdown' },
	                            React.createElement(
	                                'a',
	                                { href: '', className: 'msg dropdown-toggle' },
	                                React.createElement('i', {
	                                    className: 'fa fa-envelope-o' }),
	                                React.createElement(
	                                    'span',
	                                    null,
	                                    '15'
	                                ),
	                                React.createElement('div', { className: 'notification-ring' })
	                            )
	                        )
	                    )
	                ),
	                React.createElement(
	                    'div',
	                    { className: 'questions-section' },
	                    React.createElement(ReactIntl.FormattedMessage, {
	                        id: 'dashBoard.haveQuestions' }),
	                    React.createElement(
	                        'a',
	                        {
	                            href: 'mailto:service@hhdd.com' },
	                        'service@hhdd.com'
	                    )
	                )
	            );
	        }
	    }]);
	
	    return DashboardTop;
	}(React.Component);
	
	exports.default = ReactIntl.injectIntl(DashboardTop);
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "dashBoardTop.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! react */ 2), __webpack_require__(/*! react-intl */ 270)))

/***/ },

/***/ 885:
/*!*********************************************************************!*\
  !*** ./js/modules/include/dashBoard/dashBoardTop/dashBoardTop.scss ***!
  \*********************************************************************/
/***/ function(module, exports, __webpack_require__) {

	// style-loader: Adds some css to the DOM by adding a <style> tag
	
	// load the styles
	var content = __webpack_require__(/*! !./../../../../../../~/css-loader!./../../../../../../~/sass-loader!./dashBoardTop.scss */ 886);
	if(typeof content === 'string') content = [[module.id, content, '']];
	// add the styles to the DOM
	var update = __webpack_require__(/*! ./../../../../../../~/style-loader/addStyles.js */ 263)(content, {});
	if(content.locals) module.exports = content.locals;
	// Hot Module Replacement
	if(false) {
		// When the styles change, update the <style> tags
		if(!content.locals) {
			module.hot.accept("!!./../../../../../../node_modules/css-loader/index.js!./../../../../../../node_modules/sass-loader/index.js!./dashBoardTop.scss", function() {
				var newContent = require("!!./../../../../../../node_modules/css-loader/index.js!./../../../../../../node_modules/sass-loader/index.js!./dashBoardTop.scss");
				if(typeof newContent === 'string') newContent = [[module.id, newContent, '']];
				update(newContent);
			});
		}
		// When the module is disposed, remove the <style> tags
		module.hot.dispose(function() { update(); });
	}

/***/ },

/***/ 886:
/*!******************************************************************************************************!*\
  !*** ../~/css-loader!../~/sass-loader!./js/modules/include/dashBoard/dashBoardTop/dashBoardTop.scss ***!
  \******************************************************************************************************/
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(/*! ./../../../../../../~/css-loader/lib/css-base.js */ 262)();
	// imports
	
	
	// module
	exports.push([module.id, ".page-top {\n  background: rgba(0, 0, 0, 0.5);\n  position: fixed;\n  z-index: 904;\n  box-shadow: 2px 0 3px rgba(0, 0, 0, 0.5);\n  height: 66px;\n  width: 100%;\n  padding: 0 32px 0 40px;\n  min-width: 320px; }\n  @media (max-width: 479px) {\n    .page-top {\n      padding: 0 10px; } }\n\na.al-logo {\n  color: #fff;\n  display: block;\n  font-size: 24px;\n  white-space: nowrap;\n  float: left;\n  outline: 0 !important;\n  line-height: 60px; }\n  a.al-logo:hover {\n    color: #047ec7; }\n  a.al-logo span {\n    color: #0593e8; }\n  @media (max-width: 479px) {\n    a.al-logo {\n      font-size: 20px; } }\n\na.collapse-menu-link {\n  font-size: 31px;\n  cursor: pointer;\n  display: block;\n  text-decoration: none;\n  line-height: 42px;\n  color: #fff;\n  padding: 0;\n  float: left;\n  margin: 11px 0 0 25px;\n  font-family: 'Icomoon Icon' !important; }\n  a.collapse-menu-link:before {\n    content: \"\\E905\"; }\n  a.collapse-menu-link:hover {\n    color: #f0ad4e; }\n  @media (max-width: 479px) {\n    a.collapse-menu-link {\n      margin-left: 5px;\n      font-size: 24px; } }\n\n.search {\n  font-size: 13px;\n  line-height: 25px;\n  width: 162px;\n  float: left;\n  margin: 20px 0 0 30px;\n  color: #fff; }\n  @media (max-width: 767px) {\n    .search {\n      display: none; } }\n\n.search i {\n  width: 16px;\n  display: inline-block;\n  cursor: pointer;\n  padding-left: 1px;\n  font-size: 16px;\n  margin-right: 13px;\n  font-family: 'Icomoon Icon' !important;\n  font-style: normal; }\n  .search i:before {\n    content: \"\\E902\"; }\n\n.search input {\n  background: 0 0;\n  border: none;\n  outline: 0;\n  width: 120px;\n  padding: 0;\n  margin: 0 0 0 -3px;\n  height: 27px; }\n\n.questions-section {\n  position: absolute;\n  right: 200px;\n  top: 0;\n  height: 66px;\n  line-height: 66px; }\n  @media (max-width: 991px) {\n    .questions-section {\n      display: none; } }\n\n.user-profile {\n  float: right;\n  min-width: 170px;\n  margin-top: 10px; }\n  @media (max-width: 767px) {\n    .user-profile {\n      min-width: 136px; } }\n  .user-profile a {\n    display: block; }\n  .user-profile .al-user-profile {\n    float: right;\n    margin-right: 12px;\n    padding: 0;\n    width: 36px;\n    height: 36px;\n    border: 0;\n    opacity: 1;\n    position: relative; }\n    .user-profile .al-user-profile img {\n      width: 45px;\n      height: 45px;\n      border-radius: 50%; }\n\n.al-msg-center {\n  float: right;\n  padding: 0;\n  list-style: none;\n  margin: 13px 47px 0 0; }\n  .al-msg-center li {\n    list-style: none;\n    float: left;\n    margin-left: 30px; }\n    .al-msg-center li:first-child {\n      margin-left: 0; }\n    .al-msg-center li > a {\n      color: #fff; }\n      .al-msg-center li > a:hover .fa-bell-o {\n        color: #d9534f; }\n      .al-msg-center li > a:hover .fa-envelope-o {\n        color: #5bc0de; }\n      .al-msg-center li > a span {\n        display: inline-block;\n        min-width: 10px;\n        padding: 2px 4px;\n        color: #fff;\n        vertical-align: baseline;\n        white-space: nowrap;\n        text-align: center;\n        border-radius: 13px;\n        text-shadow: none;\n        line-height: 11px;\n        background-color: #d9534f;\n        position: absolute;\n        top: -5px;\n        right: -14px;\n        font-size: 11px; }\n      .al-msg-center li > a.msg span {\n        background-color: #5bc0de; }\n      .al-msg-center li > a .notification-ring {\n        border: 1px solid #d9534f;\n        border-radius: 100px;\n        height: 40px;\n        width: 40px;\n        position: absolute;\n        top: -18px;\n        right: -27px;\n        -webkit-animation: pulsate 8s ease-out;\n        -o-animation: pulsate 8s ease-out;\n        animation: pulsate 8s ease-out;\n        -webkit-animation-iteration-count: infinite;\n        animation-iteration-count: infinite;\n        opacity: 0; }\n      .al-msg-center li > a.msg .notification-ring {\n        border: 1px solid #5bc0de; }\n\n.fa-bell-o:before {\n  content: \"\\E907\"; }\n\n.fa-envelope-o:before {\n  content: \"\\E904\"; }\n", ""]);
	
	// exports


/***/ },

/***/ 887:
/*!*****************************************!*\
  !*** ./assets/images/profile/Nasta.png ***!
  \*****************************************/
/***/ function(module, exports, __webpack_require__) {

	module.exports = __webpack_require__.p + "./assets/images/profile/Nasta-7a79320d5a3ce7218410c86397d432de.png";

/***/ },

/***/ 888:
/*!****************************************************************************!*\
  !*** ./js/modules/include/dashBoard/dashBoardLeftNav/dashBoardLeftNav.jsx ***!
  \****************************************************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(React, classNames, CustomScrollbar, ReactRouter, ReactIntl) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	
	var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };
	
	var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();
	
	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
	
	function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }
	
	function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }
	
	/**
	 * Created by Donghui Huo on 2016/5/10.
	 */
	__webpack_require__(/*! ./dashBoardLeftNav.scss */ 889);
	
	var DashboardLeft = function (_React$Component) {
	    _inherits(DashboardLeft, _React$Component);
	
	    function DashboardLeft(props) {
	        _classCallCheck(this, DashboardLeft);
	
	        var _this = _possibleConstructorReturn(this, (DashboardLeft.__proto__ || Object.getPrototypeOf(DashboardLeft)).call(this, props));
	
	        _this.state = {};
	        return _this;
	    }
	
	    _createClass(DashboardLeft, [{
	        key: 'onMouseOut',
	        value: function onMouseOut(e) {
	            document.querySelector('.al-sidebar .direct-line').style.top = '-200px';
	        }
	    }, {
	        key: 'componentDidUpdate',
	        value: function componentDidUpdate(prevProps, prevState) {}
	    }, {
	        key: 'render',
	        value: function render() {
	            var asideClassnames = classNames('al-sidebar');
	            if (this.props.leftMenu.collapse != undefined) {
	
	                asideClassnames = classNames('al-sidebar', this.props.leftMenu.collapse ? 'collapse' : 'un-collapse');
	            }
	            return React.createElement(
	                'sidebar',
	                null,
	                React.createElement(
	                    'aside',
	                    { className: asideClassnames, onMouseOut: this.onMouseOut },
	                    React.createElement('div', { className: 'direct-line' }),
	                    React.createElement(
	                        CustomScrollbar,
	                        { style: { 'heigh': '100%' } },
	                        this.props.leftMenu.data && React.createElement(DashboardLeftList, _extends({ data: this.props.leftMenu.data.responseData.data.content }, this.props))
	                    )
	                )
	            );
	        }
	    }]);
	
	    return DashboardLeft;
	}(React.Component);
	
	var DashboardLeftList = function (_React$Component2) {
	    _inherits(DashboardLeftList, _React$Component2);
	
	    function DashboardLeftList(props) {
	        _classCallCheck(this, DashboardLeftList);
	
	        return _possibleConstructorReturn(this, (DashboardLeftList.__proto__ || Object.getPrototypeOf(DashboardLeftList)).call(this, props));
	    }
	
	    _createClass(DashboardLeftList, [{
	        key: 'componentDidMount',
	        value: function componentDidMount() {}
	    }, {
	        key: 'onMouseOver',
	        value: function onMouseOver(e) {
	            var directLine = document.querySelector('.al-sidebar .direct-line');
	            directLine.style.top = e.currentTarget.parentElement.offsetTop + 'px';
	            directLine.style.height = e.currentTarget.clientHeight + 'px';
	            e.stopPropagation();
	        }
	    }, {
	        key: 'onClick',
	        value: function onClick(e) {
	            var parentDom = e.currentTarget;
	            var subUl = parentDom.querySelector('.al-sidebar-sublist');
	            if (subUl) {
	                var sidebar = document.querySelector('.al-sidebar');
	                if (!parentDom.classList.contains('opened')) {
	                    var height = 0;
	                    var liSubList = subUl.querySelectorAll('.al-sidebar-sublist-item');
	                    for (var i = 0; i < liSubList.length; ++i) {
	                        height += liSubList[i].offsetHeight;
	                    }
	                    subUl.style.height = height + 'px';
	                    parentDom.classList.add('opened');
	                } else {
	                    if ((!sidebar || sidebar && sidebar.classList.contains('un-collapse')) && parentDom.classList.contains('opened')) {
	                        subUl.style.height = '0px';
	                        parentDom.classList.remove('opened');
	                    }
	                }
	                if (sidebar && !sidebar.classList.contains('un-collapse')) {
	                    this.props.leftMenuCollapseChange({ collapse: false });
	                }
	                e.preventDefault();
	            } else {
	                this.props.leftMenuSelectedChange({ selectedUrl: e.currentTarget.getAttribute('data-url') });
	                var w = window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth;
	                if (w < 1200) {
	                    this.props.leftMenuCollapseChange({ collapse: true });
	                }
	            }
	        }
	    }, {
	        key: 'render',
	        value: function render() {
	            var classNames = __webpack_require__(/*! classnames */ 174);
	            var items = this.props.data.map(function (item) {
	                var liClass = classNames('al-sidebar-list-item', { 'selected': item.url && item.url === this.props.leftMenu.selectedUrl ? 'selected' : null });
	                //var liClass = classNames('al-sidebar-list-item', {'selected': item.selected});
	                return item.available && React.createElement(
	                    'li',
	                    { key: item.internalId, className: liClass, 'data-url': item.moduleUrl,
	                        onClick: this.onClick.bind(this) },
	                    React.createElement(
	                        ReactRouter.Link,
	                        { className: "al-sidebar-list-link", to: item.moduleUrl ? item.moduleUrl : '#',
	                            onMouseOver: this.onMouseOver,
	                            onClick: !item.moduleUrl ? function (e) {
	                                return e.preventDefault();
	                            } : null },
	                        React.createElement('i', { className: item.iconClass }),
	                        React.createElement(
	                            'span',
	                            null,
	                            item.moduleName
	                        ),
	                        item.children ? React.createElement('b', { className: 'down' }) : null
	                    ),
	                    item.children ? React.createElement(DashboardLeftSubList, _extends({}, this.props, { data: item.children })) : null
	                );
	            }, this);
	
	            return React.createElement(
	                'ul',
	                { className: 'al-sidebar-list' },
	                items
	            );
	        }
	    }]);
	
	    return DashboardLeftList;
	}(React.Component);
	
	var DashboardLeftSubList = function (_React$Component3) {
	    _inherits(DashboardLeftSubList, _React$Component3);
	
	    function DashboardLeftSubList(props) {
	        _classCallCheck(this, DashboardLeftSubList);
	
	        return _possibleConstructorReturn(this, (DashboardLeftSubList.__proto__ || Object.getPrototypeOf(DashboardLeftSubList)).call(this, props));
	    }
	
	    _createClass(DashboardLeftSubList, [{
	        key: 'onMouseOver',
	        value: function onMouseOver(e) {
	            var directLine = document.querySelector('.al-sidebar .direct-line');
	            directLine.style.top = e.currentTarget.offsetTop + e.currentTarget.parentNode.parentNode.offsetTop + 'px';
	            directLine.style.height = e.currentTarget.clientHeight + 'px';
	            e.stopPropagation();
	        }
	    }, {
	        key: 'onClick',
	        value: function onClick(e) {
	            this.props.leftMenuSelectedChange({ selectedUrl: e.currentTarget.getAttribute('data-url') });
	            var w = window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth;
	            if (w < 1200) {
	                this.props.leftMenuCollapseChange({ collapse: true });
	            }
	            e.stopPropagation();
	        }
	    }, {
	        key: 'render',
	        value: function render() {
	            var classNames = __webpack_require__(/*! classnames */ 174);
	            var subItems = this.props.data.map(function (subItem) {
	                var liClass = classNames('al-sidebar-sublist-item', { 'selected': subItem.moduleUrl && subItem.moduleUrl === this.props.leftMenu.selectedUrl ? 'selected' : null });
	                return subItem.available && React.createElement(
	                    'li',
	                    { key: subItem.internalId, 'data-url': subItem.moduleUrl, className: liClass,
	                        onClick: this.onClick.bind(this),
	                        onMouseOver: this.onMouseOver },
	                    React.createElement(
	                        ReactRouter.Link,
	                        { className: "al-sidebar-list-link", to: subItem.moduleUrl },
	                        React.createElement(
	                            'span',
	                            null,
	                            subItem.moduleName
	                        )
	                    )
	                );
	            }, this);
	            return React.createElement(
	                'ul',
	                { className: 'al-sidebar-sublist' },
	                subItems
	            );
	        }
	    }]);
	
	    return DashboardLeftSubList;
	}(React.Component);
	
	exports.default = ReactIntl.injectIntl(DashboardLeft);
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "dashBoardLeftNav.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! react */ 2), __webpack_require__(/*! classnames */ 174), __webpack_require__(/*! ./js/modules/common/customScrollbar/customScrollbar.jsx */ 242), __webpack_require__(/*! react-router */ 776), __webpack_require__(/*! react-intl */ 270)))

/***/ },

/***/ 889:
/*!*****************************************************************************!*\
  !*** ./js/modules/include/dashBoard/dashBoardLeftNav/dashBoardLeftNav.scss ***!
  \*****************************************************************************/
/***/ function(module, exports, __webpack_require__) {

	// style-loader: Adds some css to the DOM by adding a <style> tag
	
	// load the styles
	var content = __webpack_require__(/*! !./../../../../../../~/css-loader!./../../../../../../~/sass-loader!./dashBoardLeftNav.scss */ 890);
	if(typeof content === 'string') content = [[module.id, content, '']];
	// add the styles to the DOM
	var update = __webpack_require__(/*! ./../../../../../../~/style-loader/addStyles.js */ 263)(content, {});
	if(content.locals) module.exports = content.locals;
	// Hot Module Replacement
	if(false) {
		// When the styles change, update the <style> tags
		if(!content.locals) {
			module.hot.accept("!!./../../../../../../node_modules/css-loader/index.js!./../../../../../../node_modules/sass-loader/index.js!./dashBoardLeftNav.scss", function() {
				var newContent = require("!!./../../../../../../node_modules/css-loader/index.js!./../../../../../../node_modules/sass-loader/index.js!./dashBoardLeftNav.scss");
				if(typeof newContent === 'string') newContent = [[module.id, newContent, '']];
				update(newContent);
			});
		}
		// When the module is disposed, remove the <style> tags
		module.hot.dispose(function() { update(); });
	}

/***/ },

/***/ 890:
/*!**************************************************************************************************************!*\
  !*** ../~/css-loader!../~/sass-loader!./js/modules/include/dashBoard/dashBoardLeftNav/dashBoardLeftNav.scss ***!
  \**************************************************************************************************************/
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(/*! ./../../../../../../~/css-loader/lib/css-base.js */ 262)();
	// imports
	
	
	// module
	exports.push([module.id, ".al-sidebar {\n  width: 180px;\n  top: 66px;\n  left: 0;\n  z-index: 904;\n  display: block;\n  min-height: 500px;\n  background: rgba(0, 0, 0, 0.5);\n  height: 100%;\n  position: fixed;\n  -webkit-transition: all 200ms linear;\n  -o-transition: all 200ms linear;\n  transition: all 200ms linear; }\n  @media (max-width: 1199px) {\n    .al-sidebar {\n      width: 52px; } }\n  @media (max-width: 479px) {\n    .al-sidebar {\n      width: 0px; } }\n  .al-sidebar.collapse {\n    width: 52px !important; }\n    @media (max-width: 479px) {\n      .al-sidebar.collapse {\n        width: 0px !important; } }\n    .al-sidebar.collapse .al-sidebar-list b {\n      opacity: 0;\n      filter: alpha(opacity=0); }\n    .al-sidebar.collapse .al-sidebar-sublist {\n      position: absolute;\n      width: 0;\n      overflow: hidden;\n      left: 52px;\n      top: -1px; }\n  .al-sidebar.un-collapse {\n    width: 180px !important; }\n    .al-sidebar.un-collapse .al-sidebar-list b {\n      opacity: 1;\n      filter: alpha(opacity=100); }\n    .al-sidebar.un-collapse .al-sidebar-sublist {\n      position: static;\n      width: auto; }\n\n.al-sidebar .direct-line {\n  position: absolute;\n  width: 3px;\n  right: 0px;\n  top: -200px;\n  height: 43px;\n  background-color: #0473b6;\n  -webkit-transition: all 200ms ease-in-out;\n  -o-transition: all 200ms ease-in-out;\n  transition: all 200ms ease-in-out; }\n\n.al-sidebar-list, .al-sidebar-sublist {\n  margin: 0;\n  padding: 18px 0 0;\n  list-style: none; }\n\n.al-sidebar-list {\n  font-size: 14px; }\n\n.al-sidebar-list li {\n  display: block;\n  position: relative;\n  float: none;\n  padding: 0; }\n\n.al-sidebar-list li.selected {\n  background-color: #0473b6; }\n\n.al-sidebar-list a {\n  color: #fff;\n  display: block;\n  padding-left: 18px;\n  line-height: 42px;\n  cursor: pointer;\n  text-transform: capitalize;\n  white-space: nowrap; }\n\n.al-sidebar-list li:not(.selected) a:hover, .al-sidebar-list li:not(.selected) a:active {\n  color: #0593e8; }\n  .al-sidebar-list li:not(.selected) a:hover b, .al-sidebar-list li:not(.selected) a:active b {\n    color: #0593e8; }\n\n.al-sidebar-list li.selected a:hover, .al-sidebar-list li.selected a:active {\n  color: #fff; }\n  .al-sidebar-list li.selected a:hover b, .al-sidebar-list li.selected a:active b {\n    color: #fff; }\n\n.al-sidebar-list i {\n  margin-right: 18px;\n  width: 16px;\n  display: inline-block;\n  font-family: \"Icomoon Icon\";\n  font-style: normal; }\n  .al-sidebar-list i.home:before {\n    content: '\\E900'; }\n  .al-sidebar-list i.cog:before {\n    content: '\\E901'; }\n  .al-sidebar-list i.users:before {\n    content: '\\E915'; }\n  .al-sidebar-list i.user:before {\n    content: '\\E916'; }\n  .al-sidebar-list i.lock:before {\n    content: '\\E914'; }\n  .al-sidebar-list i.app:before {\n    content: '\\E917'; }\n  .al-sidebar-list i.module:before {\n    content: '\\E918'; }\n  .al-sidebar-list i.control:before {\n    content: '\\E919'; }\n\n.al-sidebar-list b {\n  display: block;\n  line-height: 16px;\n  text-shadow: none;\n  font-size: 20px;\n  position: absolute;\n  right: 10px;\n  top: 14px;\n  padding: 0;\n  text-align: center;\n  color: #ccc;\n  font-weight: normal;\n  font-family: \"Icomoon Icon\";\n  opacity: 1;\n  filter: alpha(opacity=100); }\n  @media (max-width: 1199px) {\n    .al-sidebar-list b {\n      opacity: 0;\n      filter: alpha(opacity=0); } }\n\n.al-sidebar-list b.down:before {\n  content: '\\E903'; }\n\n.al-sidebar-list b.up:before {\n  content: '\\E906'; }\n\n.al-sidebar-sublist {\n  font-size: 13px;\n  padding-top: 0;\n  height: 0px;\n  overflow: hidden;\n  -webkit-transition: all 200ms linear;\n  -o-transition: all 200ms linear;\n  transition: all 200ms linear; }\n  @media (max-width: 1199px) {\n    .al-sidebar-sublist {\n      position: absolute;\n      width: 0;\n      overflow: hidden;\n      left: 52px;\n      top: -1px; } }\n\n.al-sidebar-list-item .down {\n  -webkit-transition: all 200ms linear;\n  -o-transition: all 200ms linear;\n  transition: all 200ms linear;\n  -webkit-transform: rotate(0deg);\n  -ms-transform: rotate(0deg);\n  -o-transform: rotate(0deg);\n  transform: rotate(0deg); }\n\n.al-sidebar-list-item.opened .al-sidebar-sublist {\n  height: auto; }\n\n.al-sidebar-list-item.opened .down {\n  -webkit-transform: rotate(180deg);\n  -ms-transform: rotate(180deg);\n  -o-transform: rotate(180deg);\n  transform: rotate(180deg); }\n\n.al-sidebar-sublist a {\n  padding-left: 52px;\n  line-height: 29px; }\n", ""]);
	
	// exports


/***/ },

/***/ 891:
/*!**********************************************************************!*\
  !*** ./js/modules/include/dashBoard/dashBoardMain/dashBoardMain.jsx ***!
  \**********************************************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(React, classNames, CustomScrollbar, ReactIntl) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	
	var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };
	
	var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();
	
	var _dashBoardMainTop = __webpack_require__(/*! ./top/dashBoardMainTop.jsx */ 892);
	
	var _dashBoardMainTop2 = _interopRequireDefault(_dashBoardMainTop);
	
	var _dashBoardMainBottom = __webpack_require__(/*! ./bottom/dashBoardMainBottom.jsx */ 893);
	
	var _dashBoardMainBottom2 = _interopRequireDefault(_dashBoardMainBottom);
	
	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }
	
	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
	
	function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }
	
	function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }
	
	/**
	 * Created by Donghui Huo on 2016/5/10.
	 */
	__webpack_require__(/*! ./dashBoardMain.scss */ 894);
	
	var DashboardMain = function (_React$Component) {
	    _inherits(DashboardMain, _React$Component);
	
	    function DashboardMain(props) {
	        _classCallCheck(this, DashboardMain);
	
	        return _possibleConstructorReturn(this, (DashboardMain.__proto__ || Object.getPrototypeOf(DashboardMain)).call(this, props));
	    }
	
	    _createClass(DashboardMain, [{
	        key: 'scrollToTop',
	        value: function scrollToTop(e) {
	            var scrollbars = this.refs.scrollbars;
	
	            scrollbars.scrollTop(0);
	        }
	    }, {
	        key: 'scrollFun',
	        value: function scrollFun() {
	            var scrollbars = this.refs.scrollbars;
	
	            if (scrollbars.getScrollTop() <= 200) {
	                document.querySelector('#backTop').style.display = 'none';
	            } else {
	                document.querySelector('#backTop').style.display = 'block';
	            }
	        }
	    }, {
	        key: 'render',
	        value: function render() {
	            var mainClassnames = classNames('al-main');
	            if (this.props.leftMenu.collapse != undefined) {
	
	                mainClassnames = classNames('al-main', this.props.leftMenu.collapse ? 'collapse' : 'un-collapse');
	            }
	            return React.createElement(
	                'main',
	                { className: mainClassnames },
	                React.createElement(
	                    CustomScrollbar,
	                    { ref: 'scrollbars', scrollFun: this.scrollFun.bind(this) },
	                    React.createElement(
	                        'div',
	                        { className: 'al-content' },
	                        React.createElement(_dashBoardMainTop2.default, null),
	                        React.cloneElement(this.props.children, _extends({}, this.props)),
	                        React.createElement(_dashBoardMainBottom2.default, null)
	                    )
	                ),
	                React.createElement(
	                    'back-top',
	                    null,
	                    React.createElement('i', { className: 'fa back-top', id: 'backTop', title: 'Back to Top',
	                        onClick: this.scrollToTop.bind(this) })
	                )
	            );
	        }
	    }]);
	
	    return DashboardMain;
	}(React.Component);
	
	exports.default = ReactIntl.injectIntl(DashboardMain);
	
	//how to change the window width, when change
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "dashBoardMain.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! react */ 2), __webpack_require__(/*! classnames */ 174), __webpack_require__(/*! ./js/modules/common/customScrollbar/customScrollbar.jsx */ 242), __webpack_require__(/*! react-intl */ 270)))

/***/ },

/***/ 892:
/*!*****************************************************************************!*\
  !*** ./js/modules/include/dashBoard/dashBoardMain/top/dashBoardMainTop.jsx ***!
  \*****************************************************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(React) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	"use strict";
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	
	var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();
	
	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
	
	function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }
	
	function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }
	
	/**
	 * Created by Donghui Huo on 2016/5/10.
	 */
	
	var DashboardMainTop = function (_React$Component) {
	    _inherits(DashboardMainTop, _React$Component);
	
	    function DashboardMainTop(props) {
	        _classCallCheck(this, DashboardMainTop);
	
	        return _possibleConstructorReturn(this, (DashboardMainTop.__proto__ || Object.getPrototypeOf(DashboardMainTop)).call(this, props));
	    }
	
	    _createClass(DashboardMainTop, [{
	        key: "render",
	        value: function render() {
	            return React.createElement(
	                "content-top",
	                null,
	                React.createElement(
	                    "div",
	                    { className: "content-top" },
	                    React.createElement(
	                        "h1",
	                        { className: "al-title" },
	                        "DASHBOARD"
	                    ),
	                    React.createElement(
	                        "ul",
	                        { className: "breadcrumb al-breadcrumb" },
	                        React.createElement(
	                            "li",
	                            null,
	                            React.createElement(
	                                "a",
	                                { href: "#" },
	                                "Home"
	                            )
	                        ),
	                        React.createElement(
	                            "li",
	                            null,
	                            "Dashboard"
	                        )
	                    )
	                )
	            );
	        }
	    }]);
	
	    return DashboardMainTop;
	}(React.Component);
	
	exports.default = DashboardMainTop;
	
	//how to change the window width, when change
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "dashBoardMainTop.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! react */ 2)))

/***/ },

/***/ 893:
/*!***********************************************************************************!*\
  !*** ./js/modules/include/dashBoard/dashBoardMain/bottom/dashBoardMainBottom.jsx ***!
  \***********************************************************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(React) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	"use strict";
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	
	var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();
	
	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
	
	function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }
	
	function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }
	
	/**
	 * Created by Donghui Huo on 2016/5/10.
	 */
	
	var DashboardMainBottom = function (_React$Component) {
	    _inherits(DashboardMainBottom, _React$Component);
	
	    function DashboardMainBottom(props) {
	        _classCallCheck(this, DashboardMainBottom);
	
	        return _possibleConstructorReturn(this, (DashboardMainBottom.__proto__ || Object.getPrototypeOf(DashboardMainBottom)).call(this, props));
	    }
	
	    _createClass(DashboardMainBottom, [{
	        key: "render",
	        value: function render() {
	            return React.createElement(
	                "footer",
	                { className: "al-footer" },
	                React.createElement(
	                    "div",
	                    { className: "al-footer-right" },
	                    "Created by Huo"
	                ),
	                React.createElement(
	                    "div",
	                    { className: "al-footer-left" },
	                    React.createElement(
	                        "span",
	                        { className: "al-copy" },
	                        "© ",
	                        React.createElement(
	                            "a",
	                            { href: "#", target: "_blank" },
	                            "Huo"
	                        ),
	                        " 2016"
	                    ),
	                    React.createElement(
	                        "ul",
	                        { className: "al-share" },
	                        React.createElement(
	                            "li",
	                            null,
	                            React.createElement(
	                                "a",
	                                { href: "#", target: "_blank" },
	                                React.createElement("i", {
	                                    className: "fa fa-wechat" })
	                            )
	                        ),
	                        React.createElement(
	                            "li",
	                            null,
	                            React.createElement(
	                                "a",
	                                { href: "#", target: "_blank" },
	                                React.createElement("i", {
	                                    className: "fa fa-weibo" })
	                            )
	                        ),
	                        React.createElement(
	                            "li",
	                            null,
	                            React.createElement(
	                                "a",
	                                { href: "#", target: "_blank" },
	                                React.createElement("i", {
	                                    className: "fa fa-facebook" })
	                            )
	                        )
	                    )
	                )
	            );
	        }
	    }]);
	
	    return DashboardMainBottom;
	}(React.Component);
	
	exports.default = DashboardMainBottom;
	
	//how to change the window width, when change
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "dashBoardMainBottom.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! react */ 2)))

/***/ },

/***/ 894:
/*!***********************************************************************!*\
  !*** ./js/modules/include/dashBoard/dashBoardMain/dashBoardMain.scss ***!
  \***********************************************************************/
/***/ function(module, exports, __webpack_require__) {

	// style-loader: Adds some css to the DOM by adding a <style> tag
	
	// load the styles
	var content = __webpack_require__(/*! !./../../../../../../~/css-loader!./../../../../../../~/sass-loader!./dashBoardMain.scss */ 895);
	if(typeof content === 'string') content = [[module.id, content, '']];
	// add the styles to the DOM
	var update = __webpack_require__(/*! ./../../../../../../~/style-loader/addStyles.js */ 263)(content, {});
	if(content.locals) module.exports = content.locals;
	// Hot Module Replacement
	if(false) {
		// When the styles change, update the <style> tags
		if(!content.locals) {
			module.hot.accept("!!./../../../../../../node_modules/css-loader/index.js!./../../../../../../node_modules/sass-loader/index.js!./dashBoardMain.scss", function() {
				var newContent = require("!!./../../../../../../node_modules/css-loader/index.js!./../../../../../../node_modules/sass-loader/index.js!./dashBoardMain.scss");
				if(typeof newContent === 'string') newContent = [[module.id, newContent, '']];
				update(newContent);
			});
		}
		// When the module is disposed, remove the <style> tags
		module.hot.dispose(function() { update(); });
	}

/***/ },

/***/ 895:
/*!********************************************************************************************************!*\
  !*** ../~/css-loader!../~/sass-loader!./js/modules/include/dashBoard/dashBoardMain/dashBoardMain.scss ***!
  \********************************************************************************************************/
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(/*! ./../../../../../../~/css-loader/lib/css-base.js */ 262)();
	// imports
	
	
	// module
	exports.push([module.id, "main, .al-main {\n  margin-left: 180px;\n  padding: 66px 0 0;\n  height: 100%;\n  -webkit-transition: all 200ms linear;\n  -o-transition: all 200ms linear;\n  transition: all 200ms linear; }\n  @media (max-width: 1199px) {\n    main, .al-main {\n      margin-left: 50px; } }\n  @media (max-width: 479px) {\n    main, .al-main {\n      margin-left: 0px; } }\n  main.collapse, .al-main.collapse {\n    margin-left: 50px; }\n    @media (max-width: 479px) {\n      main.collapse, .al-main.collapse {\n        margin-left: 0px; } }\n  main.un-collapse, .al-main.un-collapse {\n    margin-left: 180px; }\n    @media (max-width: 1199px) {\n      main.un-collapse, .al-main.un-collapse {\n        margin-left: 50px; } }\n    @media (max-width: 479px) {\n      main.un-collapse, .al-main.un-collapse {\n        margin-left: 0px; } }\n  main .back-top, .al-main .back-top {\n    width: 52px;\n    height: 52px;\n    cursor: pointer;\n    z-index: 9999;\n    display: none;\n    text-decoration: none;\n    right: 64px;\n    bottom: 40px !important;\n    font-size: 52px;\n    text-align: center;\n    opacity: .4;\n    color: #0593e8;\n    background-color: rgba(0, 0, 0, 0.5);\n    border-radius: 50%;\n    line-height: 52px;\n    position: fixed;\n    -webkit-transform: rotate(180deg);\n    -ms-transform: rotate(180deg);\n    -o-transform: rotate(180deg);\n    transform: rotate(180deg); }\n    main .back-top:before, .al-main .back-top:before {\n      content: '\\E903'; }\n    main .back-top:hover, .al-main .back-top:hover {\n      background-color: black; }\n  main .al-footer, .al-main .al-footer {\n    position: absolute;\n    vertical-align: middle;\n    line-height: 32px;\n    width: 100%;\n    display: block;\n    bottom: 0;\n    font-size: 13px;\n    color: #fff; }\n    main .al-footer:before, main .al-footer:after, .al-main .al-footer:before, .al-main .al-footer:after {\n      content: \" \";\n      display: table; }\n    main .al-footer:after, .al-main .al-footer:after {\n      clear: both; }\n    main .al-footer .al-footer-right, .al-main .al-footer .al-footer-right {\n      float: right; }\n      @media (max-width: 479px) {\n        main .al-footer .al-footer-right, .al-main .al-footer .al-footer-right {\n          float: none;\n          text-align: center; } }\n    main .al-footer .al-footer-left, .al-main .al-footer .al-footer-left {\n      float: left; }\n      @media (max-width: 479px) {\n        main .al-footer .al-footer-left, .al-main .al-footer .al-footer-left {\n          float: none;\n          text-align: center; } }\n    main .al-footer .al-copy, main .al-footer .al-share, .al-main .al-footer .al-copy, .al-main .al-footer .al-share {\n      display: inline-block; }\n    main .al-footer .al-share, .al-main .al-footer .al-share {\n      margin: 0px 0 0 12px;\n      padding: 0;\n      list-style: none; }\n      @media (max-width: 479px) {\n        main .al-footer .al-share, .al-main .al-footer .al-share {\n          margin-left: 0px; } }\n      main .al-footer .al-share li, .al-main .al-footer .al-share li {\n        display: inline-block;\n        margin-left: 16px; }\n        @media (max-width: 479px) {\n          main .al-footer .al-share li, .al-main .al-footer .al-share li {\n            margin-left: 10px; } }\n        main .al-footer .al-share li i, .al-main .al-footer .al-share li i {\n          display: inline-block;\n          cursor: pointer;\n          color: #fff;\n          padding: 0 7px;\n          box-sizing: content-box;\n          font-size: 16px; }\n          main .al-footer .al-share li i:hover, .al-main .al-footer .al-share li i:hover {\n            -webkit-transform: scale(1.2);\n            -ms-transform: scale(1.2);\n            -o-transform: scale(1.2);\n            transform: scale(1.2); }\n        main .al-footer .al-share li i.fa-wechat, .al-main .al-footer .al-share li i.fa-wechat {\n          background: #2f9833; }\n          main .al-footer .al-share li i.fa-wechat:before, .al-main .al-footer .al-share li i.fa-wechat:before {\n            content: \"\\E908\"; }\n        main .al-footer .al-share li i.fa-weibo, .al-main .al-footer .al-share li i.fa-weibo {\n          background: #f29809; }\n          main .al-footer .al-share li i.fa-weibo:before, .al-main .al-footer .al-share li i.fa-weibo:before {\n            content: \"\\E909\"; }\n        main .al-footer .al-share li i.fa-facebook, .al-main .al-footer .al-share li i.fa-facebook {\n          background: #3b5998; }\n          main .al-footer .al-share li i.fa-facebook:before, .al-main .al-footer .al-share li i.fa-facebook:before {\n            content: \"\\E90A\"; }\n  main > div > .track-vertical, .al-main > div > .track-vertical {\n    top: 0;\n    bottom: 0;\n    border-radius: 0;\n    width: 4px;\n    opacity: 1 !important; }\n    main > div > .track-vertical > .thumb-vertical, .al-main > div > .track-vertical > .thumb-vertical {\n      width: 4px; }\n\n.al-content {\n  margin: 0 20px;\n  padding: 8px 0 40px;\n  min-height: 100%;\n  position: relative; }\n  @media (max-width: 479px) {\n    .al-content {\n      margin: 0 10px; } }\n  .al-content .content-top {\n    padding-top: 13px;\n    padding-bottom: 27px; }\n    .al-content .content-top:before, .al-content .content-top:after {\n      content: \" \";\n      display: table; }\n    .al-content .content-top:after {\n      clear: both; }\n  .al-content h1.al-title {\n    text-transform: uppercase;\n    font-weight: 700;\n    float: left;\n    margin: 0;\n    padding: 0;\n    font-size: 24px;\n    opacity: .9; }\n    @media (max-width: 479px) {\n      .al-content h1.al-title {\n        font-size: 20px; } }\n  .al-content ul.al-breadcrumb {\n    padding: 3px 0 0;\n    margin: 0;\n    float: right;\n    list-style: none; }\n    .al-content ul.al-breadcrumb > li {\n      font-size: 18px;\n      font-weight: 400;\n      display: inline-block; }\n      @media (max-width: 479px) {\n        .al-content ul.al-breadcrumb > li {\n          font-size: 15px; } }\n    .al-content ul.al-breadcrumb > li + li:before {\n      padding: 0 5px;\n      color: #ccc;\n      content: \"/\\A0\"; }\n", ""]);
	
	// exports


/***/ },

/***/ 896:
/*!*****************************************************!*\
  !*** ./js/modules/include/dashBoard/dashBoard.scss ***!
  \*****************************************************/
/***/ function(module, exports, __webpack_require__) {

	// style-loader: Adds some css to the DOM by adding a <style> tag
	
	// load the styles
	var content = __webpack_require__(/*! !./../../../../../~/css-loader!./../../../../../~/sass-loader!./dashBoard.scss */ 897);
	if(typeof content === 'string') content = [[module.id, content, '']];
	// add the styles to the DOM
	var update = __webpack_require__(/*! ./../../../../../~/style-loader/addStyles.js */ 263)(content, {});
	if(content.locals) module.exports = content.locals;
	// Hot Module Replacement
	if(false) {
		// When the styles change, update the <style> tags
		if(!content.locals) {
			module.hot.accept("!!./../../../../../node_modules/css-loader/index.js!./../../../../../node_modules/sass-loader/index.js!./dashBoard.scss", function() {
				var newContent = require("!!./../../../../../node_modules/css-loader/index.js!./../../../../../node_modules/sass-loader/index.js!./dashBoard.scss");
				if(typeof newContent === 'string') newContent = [[module.id, newContent, '']];
				update(newContent);
			});
		}
		// When the module is disposed, remove the <style> tags
		module.hot.dispose(function() { update(); });
	}

/***/ },

/***/ 897:
/*!**************************************************************************************!*\
  !*** ../~/css-loader!../~/sass-loader!./js/modules/include/dashBoard/dashBoard.scss ***!
  \**************************************************************************************/
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(/*! ./../../../../../~/css-loader/lib/css-base.js */ 262)();
	// imports
	
	
	// module
	exports.push([module.id, "", ""]);
	
	// exports


/***/ },

/***/ 898:
/*!**********************************************!*\
  !*** ./js/modules/index/middleware/index.js ***!
  \**********************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(MiddleWare) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	Object.defineProperty(exports, "__esModule", {
	  value: true
	});
	
	var _dashBoard = __webpack_require__(/*! ./dashBoard */ 844);
	
	var _dashBoard2 = _interopRequireDefault(_dashBoard);
	
	var _table = __webpack_require__(/*! ./table */ 847);
	
	var _table2 = _interopRequireDefault(_table);
	
	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }
	
	//export  {default as dashBoard }  from './dashBoard'
	// for prepare to the default call, special parameters
	exports.default = [].concat(_dashBoard2.default, _table2.default, MiddleWare.defaultCall);
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! ./js/modules/common/middleware/index.js */ 364)))

/***/ }

});
//# sourceMappingURL=index.js.map