webpackJsonp([2],{

/***/ 0:
/*!************************************!*\
  !*** ./js/modules/index/index.jsx ***!
  \************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(ConfigureStore, ReactRouterRedux, ReactRouter, ReactDOM, React, RootContainer) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	var _reducers = __webpack_require__(/*! ./reducers */ 841);
	
	var _reducers2 = _interopRequireDefault(_reducers);
	
	var _routes = __webpack_require__(/*! ./routes */ 848);
	
	var _routes2 = _interopRequireDefault(_routes);
	
	var _middleware = __webpack_require__(/*! ./middleware */ 884);
	
	var _middleware2 = _interopRequireDefault(_middleware);
	
	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }
	
	var store = ConfigureStore.configureStore({ reducer: _reducers2.default, middleware: _middleware2.default }); /**
	                                                                                                               * Created by Donghui Huo on 2016/5/11.
	                                                                                                               */
	
	var history = ReactRouterRedux.syncHistoryWithStore(ReactRouter.browserHistory, store);
	
	ReactDOM.render(React.createElement(RootContainer, { store: store, history: history, routes: _routes2.default }), document.querySelector('#entirety'));
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! ./js/modules/common/store/configureStore.js */ 552), __webpack_require__(/*! react-router-redux */ 773), __webpack_require__(/*! react-router */ 778), __webpack_require__(/*! react-dom */ 35), __webpack_require__(/*! react */ 2), __webpack_require__(/*! ./js/modules/common/containers/Root.js */ 839)))

/***/ },

/***/ 841:
/*!********************************************!*\
  !*** ./js/modules/index/reducers/index.js ***!
  \********************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(ReactRouterRedux, Redux) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	
	var _reducers = __webpack_require__(/*! ../../include/dashBoard/reducers */ 842);
	
	var _reducers2 = _interopRequireDefault(_reducers);
	
	var _reducers3 = __webpack_require__(/*! ../../common/table/reducers */ 844);
	
	var _reducers4 = _interopRequireDefault(_reducers3);
	
	var _reducers5 = __webpack_require__(/*! ../../common/responsiveCharts/reducers */ 845);
	
	var _reducers6 = _interopRequireDefault(_reducers5);
	
	var _reducers7 = __webpack_require__(/*! ../../common/form/reducers */ 846);
	
	var _reducers8 = _interopRequireDefault(_reducers7);
	
	var _reducers9 = __webpack_require__(/*! ../../common/dragDrop/reducers */ 847);
	
	var _reducers10 = _interopRequireDefault(_reducers9);
	
	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }
	
	var routing = ReactRouterRedux.routerReducer;
	var rootReducer = Redux.combineReducers({
	    dashBoardFramework: _reducers2.default,
	    table: _reducers4.default,
	    chart: _reducers6.default,
	    form: _reducers8.default,
	    dragDrop: _reducers10.default,
	    routing: routing
	});
	exports.default = rootReducer;
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! react-router-redux */ 773), __webpack_require__(/*! redux */ 336)))

/***/ },

/***/ 842:
/*!********************************************************!*\
  !*** ./js/modules/include/dashBoard/reducers/index.js ***!
  \********************************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(l_merge, Redux) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	
	var _actions = __webpack_require__(/*! ../actions/ */ 843);
	
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
	    if (action.type === '@@router/LOCATION_CHANGE') {
	        //do the selectd
	        var pathname = action.payload.pathname;
	        //if (state.data.responseData.content) {}
	    }
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
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! lodash/merge */ 512), __webpack_require__(/*! redux */ 336)))

/***/ },

/***/ 843:
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
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! ./js/modules/common/middleware/index.js */ 352)))

/***/ },

/***/ 844:
/*!***************************************************!*\
  !*** ./js/modules/common/table/reducers/index.js ***!
  \***************************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(humps, normalizr, l_merge, Redux) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	
	var _actions = __webpack_require__(/*! ../actions */ 458);
	
	var ActionTypes = _interopRequireWildcard(_actions);
	
	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }
	
	function main() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? {} : arguments[0];
	    var action = arguments[1];
	
	    if (action.type === ActionTypes.TABLE_SUCCESS) {
	        if (!state[action.requestCondition.symbol]) {
	            state[action.requestCondition.symbol] = {};
	        }
	        if (action.response) {
	            state[action.requestCondition.symbol].status = action.response.status;
	            if (action.response.message) {
	                state[action.requestCondition.symbol].message = action.response.message;
	            }
	        }
	        if (action.response && action.response.status == 'success') {
	            state[action.requestCondition.symbol].requestCondition = action['requestCondition'];
	            state[action.requestCondition.symbol].tableRefresh = false;
	            if (action.response.responseData) {
	                if (action.response.responseData) {
	                    if (action.response.responseData.data) {
	                        var camelizedJson = humps.camelizeKeys(action.response.responseData.data);
	                        camelizedJson = Object.assign(normalizr.normalize(camelizedJson, ActionTypes.Schemas.TableData));
	                        state[action.requestCondition.symbol].keys = camelizedJson.result;
	                        var tableData = state[action.requestCondition.symbol].keys.map(function (id) {
	                            return camelizedJson.entities.tableData[id];
	                        });
	                        state[action.requestCondition.symbol].tableData = tableData;
	                    }
	                    if (action.requestCondition.init) {
	                        state[action.requestCondition.symbol].tableRules = action.response.responseData.rules;
	                        state[action.requestCondition.symbol].additionalFeature = action.response.responseData.additionalFeature;
	                    }
	                    state[action.requestCondition.symbol].totalCount = action.response.responseData.totalCount;
	                }
	                return l_merge({}, state);
	            }
	        } else {
	            ActionTypes.callbackFailure(action.response);
	        }
	    }
	    if (action.type === ActionTypes.TABLE_ROW_ADD_SUCCESS || action.type === ActionTypes.TABLE_ROW_DELETE_SUCCESS) {
	        state[action.requestCondition.symbol].tableRefresh = true;
	
	        if (action.response.status == 'success') {
	            return l_merge({}, state);
	        } else {
	            ActionTypes.callbackFailure(action.response);
	        }
	    }
	    return state;
	}
	
	exports.default = Redux.combineReducers({ main: main });
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! humps */ 446), __webpack_require__(/*! normalizr */ 447), __webpack_require__(/*! lodash/merge */ 512), __webpack_require__(/*! redux */ 336)))

/***/ },

/***/ 845:
/*!**************************************************************!*\
  !*** ./js/modules/common/responsiveCharts/reducers/index.js ***!
  \**************************************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(l_merge, Redux) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	
	var _actions = __webpack_require__(/*! ../actions/ */ 351);
	
	var ActionTypes = _interopRequireWildcard(_actions);
	
	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }
	
	function main() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? {} : arguments[0];
	    var action = arguments[1];
	
	    if (action.type === ActionTypes.CHART_SUCCESS) {
	        state[action.requestCondition.symbol] = {};
	        if (action.response) {
	            state[action.requestCondition.symbol].status = action.response.status;
	            if (action.response.message) {
	                state[action.requestCondition.symbol].message = action.response.message;
	            }
	            if (action.response.status == 'success') {
	                state[action.requestCondition.symbol].data = action.response.responseData;
	            }
	        }
	        state[action.requestCondition.symbol].requestCondition = action['requestCondition'];
	        return l_merge({}, state);
	    }
	    return state;
	}
	
	exports.default = Redux.combineReducers({
	    main: main
	});
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! lodash/merge */ 512), __webpack_require__(/*! redux */ 336)))

/***/ },

/***/ 846:
/*!**************************************************!*\
  !*** ./js/modules/common/form/reducers/index.js ***!
  \**************************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(l_merge, Redux) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	
	var _actions = __webpack_require__(/*! ../actions */ 465);
	
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
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! lodash/merge */ 512), __webpack_require__(/*! redux */ 336)))

/***/ },

/***/ 847:
/*!******************************************************!*\
  !*** ./js/modules/common/dragDrop/reducers/index.js ***!
  \******************************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(l_merge, Redux) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	"use strict";
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	
	var _actions = __webpack_require__(/*! ../actions */ 493);
	
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
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! lodash/merge */ 512), __webpack_require__(/*! redux */ 336)))

/***/ },

/***/ 848:
/*!******************************************!*\
  !*** ./js/modules/index/routes/index.js ***!
  \******************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(React, ReactRouter) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	Object.defineProperty(exports, "__esModule", {
	        value: true
	});
	
	var _containers = __webpack_require__(/*! ../containers */ 849);
	
	var Index = _interopRequireWildcard(_containers);
	
	var _dashBoard = __webpack_require__(/*! ../../include/dashBoard/dashBoard.jsx */ 869);
	
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
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! react */ 2), __webpack_require__(/*! react-router */ 778)))

/***/ },

/***/ 849:
/*!**********************************************!*\
  !*** ./js/modules/index/containers/index.js ***!
  \**********************************************/
/***/ function(module, exports, __webpack_require__) {

	/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	Object.defineProperty(exports, "__esModule", {
	  value: true
	});
	
	var _dashBoard = __webpack_require__(/*! ./dashBoard */ 850);
	
	Object.defineProperty(exports, 'dashBoard', {
	  enumerable: true,
	  get: function get() {
	    return _interopRequireDefault(_dashBoard).default;
	  }
	});
	
	var _chart = __webpack_require__(/*! ./chart */ 853);
	
	Object.defineProperty(exports, 'chart', {
	  enumerable: true,
	  get: function get() {
	    return _interopRequireDefault(_chart).default;
	  }
	});
	
	var _table = __webpack_require__(/*! ./table */ 857);
	
	Object.defineProperty(exports, 'table', {
	  enumerable: true,
	  get: function get() {
	    return _interopRequireDefault(_table).default;
	  }
	});
	
	var _form = __webpack_require__(/*! ./form */ 861);
	
	Object.defineProperty(exports, 'form', {
	  enumerable: true,
	  get: function get() {
	    return _interopRequireDefault(_form).default;
	  }
	});
	
	var _dragDrop = __webpack_require__(/*! ./dragDrop */ 865);
	
	Object.defineProperty(exports, 'dragDrop', {
	  enumerable: true,
	  get: function get() {
	    return _interopRequireDefault(_dragDrop).default;
	  }
	});

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }

/***/ },

/***/ 850:
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
	__webpack_require__(/*! ./index.scss */ 851);
	
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
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! react */ 2), __webpack_require__(/*! ./js/modules/common/panel/panel.jsx */ 300), __webpack_require__(/*! ./js/modules/common/toast/toast.jsx */ 461), __webpack_require__(/*! ./js/modules/common/modal/modal.jsx */ 267), __webpack_require__(/*! ./js/modules/common/tab/tab.jsx */ 454), __webpack_require__(/*! react-intl */ 270), __webpack_require__(/*! ./js/util/utilFun */ 268), __webpack_require__(/*! ./js/modules/common/layout/layout.jsx */ 264), __webpack_require__(/*! react-redux */ 329)))

/***/ },

/***/ 851:
/*!**********************************************************!*\
  !*** ./js/modules/index/containers/dashBoard/index.scss ***!
  \**********************************************************/
/***/ function(module, exports, __webpack_require__) {

	// style-loader: Adds some css to the DOM by adding a <style> tag
	
	// load the styles
	var content = __webpack_require__(/*! !./../../../../../../~/css-loader!./../../../../../../~/sass-loader!./index.scss */ 852);
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

/***/ 852:
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

/***/ 853:
/*!****************************************************!*\
  !*** ./js/modules/index/containers/chart/index.js ***!
  \****************************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(React, Panel, ReactIntl, UtilFun, Layout) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	
	var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();
	
	var _DefaultChartWrapper = __webpack_require__(/*! ../../components/chart/DefaultChartWrapper */ 854);
	
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
	        key: 'render',
	        value: function render() {
	
	            var columns = [React.createElement(
	                Panel.PanelWithHeader,
	                { panelValues: { title: 'Default Line Chart' } },
	                React.createElement(_DefaultChartWrapper.BarChartWrapper, null)
	            ), React.createElement(
	                Panel.PanelWithHeader,
	                { panelValues: { title: 'Default Area Chart' } },
	                React.createElement(_DefaultChartWrapper.AreaChartWrapper, null)
	            )];
	            var columns2 = [React.createElement(
	                Panel.PanelWithHeader,
	                { panelValues: { title: 'Default Bar Chart' } },
	                React.createElement(_DefaultChartWrapper.LineChartWrapper, null)
	            ), React.createElement(
	                Panel.PanelWithHeader,
	                { panelValues: { title: 'Default Pie Chart' } },
	                React.createElement(_DefaultChartWrapper.PieChartWrapper, null)
	            )];
	
	            var columns3 = [React.createElement(
	                Panel.PanelWithHeader,
	                { panelValues: { title: 'Default Scatter Chart' } },
	                React.createElement(_DefaultChartWrapper.ScatterChartWrapper, null)
	            ), React.createElement(
	                Panel.PanelWithHeader,
	                { panelValues: { title: 'Default Treemap Chart' } },
	                React.createElement(_DefaultChartWrapper.TreemapChartWrapper, null)
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
	
	exports.default = DashBoardMainBlock;
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! react */ 2), __webpack_require__(/*! ./js/modules/common/panel/panel.jsx */ 300), __webpack_require__(/*! react-intl */ 270), __webpack_require__(/*! ./js/util/utilFun */ 268), __webpack_require__(/*! ./js/modules/common/layout/layout.jsx */ 264)))

/***/ },

/***/ 854:
/*!******************************************************************!*\
  !*** ./js/modules/index/components/chart/DefaultChartWrapper.js ***!
  \******************************************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(React, ResponsiveCharts) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	
	var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();
	
	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
	
	function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }
	
	function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }
	
	var LineChartWrapper = exports.LineChartWrapper = function (_React$Component) {
	    _inherits(LineChartWrapper, _React$Component);
	
	    function LineChartWrapper() {
	        _classCallCheck(this, LineChartWrapper);
	
	        return _possibleConstructorReturn(this, (LineChartWrapper.__proto__ || Object.getPrototypeOf(LineChartWrapper)).apply(this, arguments));
	    }
	
	    _createClass(LineChartWrapper, [{
	        key: 'render',
	        value: function render() {
	            var symbol = 'chart-' + 'base-chart-1';
	            return React.createElement(ResponsiveCharts.LineChart, {
	                symbol: symbol,
	                legend: true,
	                yAxisLabel: 'Altitude',
	                xAxisLabel: 'Elapsed Time (sec)',
	                domain: { x: [, 6], y: [-10] },
	                gridHorizontal: true,
	                endpoint: 'demoData/chartData/line.json' });
	        }
	    }]);
	
	    return LineChartWrapper;
	}(React.Component);
	
	var AreaChartWrapper = exports.AreaChartWrapper = function (_React$Component2) {
	    _inherits(AreaChartWrapper, _React$Component2);
	
	    function AreaChartWrapper() {
	        _classCallCheck(this, AreaChartWrapper);
	
	        return _possibleConstructorReturn(this, (AreaChartWrapper.__proto__ || Object.getPrototypeOf(AreaChartWrapper)).apply(this, arguments));
	    }
	
	    _createClass(AreaChartWrapper, [{
	        key: 'render',
	        value: function render() {
	            var symbol = 'chart-' + 'base-chart-2';
	            return React.createElement(ResponsiveCharts.AreaChart, {
	                symbol: symbol,
	                legend: true,
	                xAxisTickInterval: { unit: 'year', interval: 2 },
	                yAxisLabel: 'Altitude',
	                xAxisLabel: 'Elapsed Time (sec)',
	                xAccessor: function xAccessor(d) {
	                    return new Date(d[0]);
	                },
	                yAccessor: function yAccessor(d) {
	                    return d[1];
	                },
	                domain: { y: [, 60] },
	                endpoint: 'demoData/chartData/area.json' });
	        }
	    }]);
	
	    return AreaChartWrapper;
	}(React.Component);
	
	var BarChartWrapper = exports.BarChartWrapper = function (_React$Component3) {
	    _inherits(BarChartWrapper, _React$Component3);
	
	    function BarChartWrapper() {
	        _classCallCheck(this, BarChartWrapper);
	
	        return _possibleConstructorReturn(this, (BarChartWrapper.__proto__ || Object.getPrototypeOf(BarChartWrapper)).apply(this, arguments));
	    }
	
	    _createClass(BarChartWrapper, [{
	        key: 'render',
	        value: function render() {
	            var symbol = 'chart-' + 'base-chart-123';
	            return React.createElement(ResponsiveCharts.BarChart, {
	                symbol: symbol,
	                legend: true,
	                xAxisLabel: 'Position',
	                yAxisLabel: 'Value',
	                endpoint: 'demoData/chartData/bar.json' });
	        }
	    }]);
	
	    return BarChartWrapper;
	}(React.Component);
	
	var PieChartWrapper = exports.PieChartWrapper = function (_React$Component4) {
	    _inherits(PieChartWrapper, _React$Component4);
	
	    function PieChartWrapper() {
	        _classCallCheck(this, PieChartWrapper);
	
	        return _possibleConstructorReturn(this, (PieChartWrapper.__proto__ || Object.getPrototypeOf(PieChartWrapper)).apply(this, arguments));
	    }
	
	    _createClass(PieChartWrapper, [{
	        key: 'render',
	        value: function render() {
	            var symbol = 'chart-' + 'base-chart-4';
	            return React.createElement(ResponsiveCharts.PieChart, {
	                symbol: symbol,
	                sectorBorderColor: 'white',
	                endpoint: 'demoData/chartData/pie.json' });
	        }
	    }]);
	
	    return PieChartWrapper;
	}(React.Component);
	
	var ScatterChartWrapper = exports.ScatterChartWrapper = function (_React$Component5) {
	    _inherits(ScatterChartWrapper, _React$Component5);
	
	    function ScatterChartWrapper() {
	        _classCallCheck(this, ScatterChartWrapper);
	
	        return _possibleConstructorReturn(this, (ScatterChartWrapper.__proto__ || Object.getPrototypeOf(ScatterChartWrapper)).apply(this, arguments));
	    }
	
	    _createClass(ScatterChartWrapper, [{
	        key: 'render',
	        value: function render() {
	            var symbol = 'chart-' + 'base-chart-5';
	            return React.createElement(ResponsiveCharts.ScatterChart, {
	                symbol: symbol,
	                legend: true,
	                domain: { x: [-15], y: [-15] },
	                endpoint: 'demoData/chartData/scatter.json' });
	        }
	    }]);
	
	    return ScatterChartWrapper;
	}(React.Component);
	
	var TreemapChartWrapper = exports.TreemapChartWrapper = function (_React$Component6) {
	    _inherits(TreemapChartWrapper, _React$Component6);
	
	    function TreemapChartWrapper() {
	        _classCallCheck(this, TreemapChartWrapper);
	
	        return _possibleConstructorReturn(this, (TreemapChartWrapper.__proto__ || Object.getPrototypeOf(TreemapChartWrapper)).apply(this, arguments));
	    }
	
	    _createClass(TreemapChartWrapper, [{
	        key: 'render',
	        value: function render() {
	            var symbol = 'chart-' + 'base-chart-6';
	            return React.createElement(ResponsiveCharts.TreemapChart, {
	                symbol: symbol,
	                legend: true,
	                hoverAnimation: true,
	                endpoint: 'demoData/chartData/treemap.json' });
	        }
	    }]);
	
	    return TreemapChartWrapper;
	}(React.Component);
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "DefaultChartWrapper.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! react */ 2), __webpack_require__(/*! ./js/modules/common/responsiveCharts/responsiveCharts.jsx */ 304)))

/***/ },

/***/ 855:
/*!******************************************************!*\
  !*** ./js/modules/index/containers/chart/index.scss ***!
  \******************************************************/
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

/***/ 857:
/*!****************************************************!*\
  !*** ./js/modules/index/containers/table/index.js ***!
  \****************************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(React, Panel, Layout) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	
	var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();
	
	var _DefaultTableWrapper = __webpack_require__(/*! ../../components/table/DefaultTableWrapper */ 858);
	
	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
	
	function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }
	
	function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }
	
	/**
	 * Created by Donghui Huo on 2016/5/11.
	 */
	__webpack_require__(/*! ./index.scss */ 859);
	
	var TableMainBlock = function (_React$Component) {
	    _inherits(TableMainBlock, _React$Component);
	
	    function TableMainBlock(props) {
	        _classCallCheck(this, TableMainBlock);
	
	        return _possibleConstructorReturn(this, (TableMainBlock.__proto__ || Object.getPrototypeOf(TableMainBlock)).call(this, props));
	    }
	
	    _createClass(TableMainBlock, [{
	        key: 'render',
	        value: function render() {
	            var columns1 = [React.createElement(
	                Panel.PanelWithHeader,
	                { panelValues: { title: 'Basic default Table' } },
	                React.createElement(_DefaultTableWrapper.DefaultTableWrapper, null)
	            ), React.createElement(
	                Panel.PanelWithHeader,
	                { panelValues: { title: 'Basic Border Table' } },
	                React.createElement(_DefaultTableWrapper.BorderTableWrapper, null)
	            )];
	            var columns2 = [React.createElement(
	                Panel.PanelWithHeader,
	                { panelValues: { title: 'Basic Condensed Table' } },
	                React.createElement(_DefaultTableWrapper.CondensedTableWrapper, null)
	            ), React.createElement(
	                Panel.PanelWithHeader,
	                { panelValues: { title: 'Basic Hover Table' } },
	                React.createElement(_DefaultTableWrapper.HoverTableWrapper, null)
	            )];
	            var columns3 = [React.createElement(
	                Panel.PanelWithHeader,
	                { panelValues: { title: 'Basic Striped Table' } },
	                React.createElement(_DefaultTableWrapper.StripedTableWrapper, null)
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
	                    { panelValues: { title: 'RowEditable Table' } },
	                    React.createElement(_DefaultTableWrapper.RowEditableTableWrapper, null)
	                )
	            );
	        }
	    }]);
	
	    return TableMainBlock;
	}(React.Component);
	
	exports.default = TableMainBlock;
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! react */ 2), __webpack_require__(/*! ./js/modules/common/panel/panel.jsx */ 300), __webpack_require__(/*! ./js/modules/common/layout/layout.jsx */ 264)))

/***/ },

/***/ 858:
/*!******************************************************************!*\
  !*** ./js/modules/index/components/table/DefaultTableWrapper.js ***!
  \******************************************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(React, Table) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	
	var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };
	
	var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();
	
	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
	
	function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }
	
	function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }
	
	//--DEMOtABLE STRUCTURE
	var demoTableRules = {
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
	var rowEditableAdditionalFeature = {
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
	var endpoints = {
	    getTableUrl: '/demoData/table/tableData.json',
	    addTableRowUrl: '/demoData/table/addData.json',
	    deleteTableRowUrl: '/demoData/table/deleteData.json',
	    updateTableRowUrl: '/demoData/table/updateData.json',
	    updateTableColumnUrl: '/demoData/table/updateData.json'
	};
	
	var endpointsRowEdit = {
	    getTableUrl: '/demoData/table/tableData1.json',
	    addTableRowUrl: '/demoData/table/addData.json',
	    deleteTableRowUrl: '/demoData/table/deleteData.json',
	    updateTableRowUrl: '/demoData/table/updateData.json',
	    updateTableColumnUrl: '/demoData/table/updateData.json'
	};
	
	var BorderTableWrapper = exports.BorderTableWrapper = function (_React$Component) {
	    _inherits(BorderTableWrapper, _React$Component);
	
	    function BorderTableWrapper() {
	        _classCallCheck(this, BorderTableWrapper);
	
	        return _possibleConstructorReturn(this, (BorderTableWrapper.__proto__ || Object.getPrototypeOf(BorderTableWrapper)).apply(this, arguments));
	    }
	
	    _createClass(BorderTableWrapper, [{
	        key: 'render',
	        value: function render() {
	            var symbol = 'table-' + 'base-table-1';
	            return React.createElement(Table.BorderTable, _extends({ minHeight: 300, endpoints: endpoints,
	                symbol: symbol }, this.props));
	        }
	    }]);
	
	    return BorderTableWrapper;
	}(React.Component);
	
	var CondensedTableWrapper = exports.CondensedTableWrapper = function (_React$Component2) {
	    _inherits(CondensedTableWrapper, _React$Component2);
	
	    function CondensedTableWrapper() {
	        _classCallCheck(this, CondensedTableWrapper);
	
	        return _possibleConstructorReturn(this, (CondensedTableWrapper.__proto__ || Object.getPrototypeOf(CondensedTableWrapper)).apply(this, arguments));
	    }
	
	    _createClass(CondensedTableWrapper, [{
	        key: 'render',
	        value: function render() {
	            var symbol = 'table-' + 'base-table-2';
	            return React.createElement(Table.CondensedTable, _extends({ minHeight: 300, endpoints: endpoints,
	                symbol: symbol }, this.props));
	        }
	    }]);
	
	    return CondensedTableWrapper;
	}(React.Component);
	
	var HoverTableWrapper = exports.HoverTableWrapper = function (_React$Component3) {
	    _inherits(HoverTableWrapper, _React$Component3);
	
	    function HoverTableWrapper() {
	        _classCallCheck(this, HoverTableWrapper);
	
	        return _possibleConstructorReturn(this, (HoverTableWrapper.__proto__ || Object.getPrototypeOf(HoverTableWrapper)).apply(this, arguments));
	    }
	
	    _createClass(HoverTableWrapper, [{
	        key: 'render',
	        value: function render() {
	            var symbol = 'table-' + 'base-table-3';
	            return React.createElement(Table.HoverTable, _extends({ minHeight: 300, endpoints: endpoints,
	                symbol: symbol }, this.props));
	        }
	    }]);
	
	    return HoverTableWrapper;
	}(React.Component);
	
	var StripedTableWrapper = exports.StripedTableWrapper = function (_React$Component4) {
	    _inherits(StripedTableWrapper, _React$Component4);
	
	    function StripedTableWrapper() {
	        _classCallCheck(this, StripedTableWrapper);
	
	        return _possibleConstructorReturn(this, (StripedTableWrapper.__proto__ || Object.getPrototypeOf(StripedTableWrapper)).apply(this, arguments));
	    }
	
	    _createClass(StripedTableWrapper, [{
	        key: 'render',
	        value: function render() {
	            var symbol = 'table-' + 'base-table-4';
	            return React.createElement(Table.StripedTable, _extends({ minHeight: 300, endpoints: endpoints,
	                symbol: symbol }, this.props));
	        }
	    }]);
	
	    return StripedTableWrapper;
	}(React.Component);
	
	var DefaultTableWrapper = exports.DefaultTableWrapper = function (_React$Component5) {
	    _inherits(DefaultTableWrapper, _React$Component5);
	
	    function DefaultTableWrapper() {
	        _classCallCheck(this, DefaultTableWrapper);
	
	        return _possibleConstructorReturn(this, (DefaultTableWrapper.__proto__ || Object.getPrototypeOf(DefaultTableWrapper)).apply(this, arguments));
	    }
	
	    _createClass(DefaultTableWrapper, [{
	        key: 'render',
	        value: function render() {
	            var symbol = 'table-' + 'base-table-5';
	            return React.createElement(Table.DefaultTable, _extends({ minHeight: 300, endpoints: endpoints,
	                symbol: symbol }, this.props));
	        }
	    }]);
	
	    return DefaultTableWrapper;
	}(React.Component);
	
	var RowEditableTableWrapper = exports.RowEditableTableWrapper = function (_React$Component6) {
	    _inherits(RowEditableTableWrapper, _React$Component6);
	
	    function RowEditableTableWrapper() {
	        _classCallCheck(this, RowEditableTableWrapper);
	
	        return _possibleConstructorReturn(this, (RowEditableTableWrapper.__proto__ || Object.getPrototypeOf(RowEditableTableWrapper)).apply(this, arguments));
	    }
	
	    _createClass(RowEditableTableWrapper, [{
	        key: 'render',
	        value: function render() {
	            var symbol = 'table-' + 'base-table-6';
	            return React.createElement(Table.RowEditableTable, _extends({ minHeight: 300, endpoints: endpointsRowEdit,
	                symbol: symbol }, this.props));
	        }
	    }]);
	
	    return RowEditableTableWrapper;
	}(React.Component);
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "DefaultTableWrapper.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! react */ 2), __webpack_require__(/*! ./js/modules/common/table/table.jsx */ 457)))

/***/ },

/***/ 859:
/*!******************************************************!*\
  !*** ./js/modules/index/containers/table/index.scss ***!
  \******************************************************/
/***/ function(module, exports, __webpack_require__) {

	// style-loader: Adds some css to the DOM by adding a <style> tag
	
	// load the styles
	var content = __webpack_require__(/*! !./../../../../../../~/css-loader!./../../../../../../~/sass-loader!./index.scss */ 860);
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

/***/ 860:
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

/***/ 861:
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
	
	var _DefaultFormWrapper = __webpack_require__(/*! ../../components/form/DefaultFormWrapper */ 862);
	
	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
	
	function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }
	
	function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }
	
	/**
	 * Created by Donghui Huo on 2016/5/11.
	 */
	__webpack_require__(/*! ./index.scss */ 863);
	
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

/***/ 862:
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
	
	var _actions = __webpack_require__(/*! ../../../common/form/actions */ 465);
	
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
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! react */ 2), __webpack_require__(/*! ./js/modules/common/form/form.jsx */ 464)))

/***/ },

/***/ 863:
/*!*****************************************************!*\
  !*** ./js/modules/index/containers/form/index.scss ***!
  \*****************************************************/
/***/ function(module, exports, __webpack_require__) {

	// style-loader: Adds some css to the DOM by adding a <style> tag
	
	// load the styles
	var content = __webpack_require__(/*! !./../../../../../../~/css-loader!./../../../../../../~/sass-loader!./index.scss */ 864);
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

/***/ 864:
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

/***/ 865:
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
	
	var _DefaultDragDropWrapper = __webpack_require__(/*! ../../components/dragDrop/DefaultDragDropWrapper */ 866);
	
	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
	
	function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }
	
	function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }
	
	/**
	 * Created by Donghui Huo on 2016/5/11.
	 */
	__webpack_require__(/*! ./index.scss */ 867);
	
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

/***/ 866:
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
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! react */ 2), __webpack_require__(/*! ./js/modules/common/dragDrop/dragDrop.jsx */ 491)))

/***/ },

/***/ 867:
/*!*********************************************************!*\
  !*** ./js/modules/index/containers/dragDrop/index.scss ***!
  \*********************************************************/
/***/ function(module, exports, __webpack_require__) {

	// style-loader: Adds some css to the DOM by adding a <style> tag
	
	// load the styles
	var content = __webpack_require__(/*! !./../../../../../../~/css-loader!./../../../../../../~/sass-loader!./index.scss */ 868);
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

/***/ 868:
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

/***/ 869:
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
	
	var _actions = __webpack_require__(/*! ./actions */ 843);
	
	var _dashBoardTop = __webpack_require__(/*! ./dashBoardTop/dashBoardTop.jsx */ 870);
	
	var _dashBoardTop2 = _interopRequireDefault(_dashBoardTop);
	
	var _dashBoardLeftNav = __webpack_require__(/*! ./dashBoardLeftNav/dashBoardLeftNav.jsx */ 874);
	
	var _dashBoardLeftNav2 = _interopRequireDefault(_dashBoardLeftNav);
	
	var _dashBoardMain = __webpack_require__(/*! ./dashBoardMain/dashBoardMain.jsx */ 877);
	
	var _dashBoardMain2 = _interopRequireDefault(_dashBoardMain);
	
	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }
	
	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
	
	function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }
	
	function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }
	
	/**
	 * Created by Donghui Huo on 2016/5/10.
	 */
	__webpack_require__(/*! ./dashBoard.scss */ 882);
	
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
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! react */ 2), __webpack_require__(/*! react-intl */ 270), __webpack_require__(/*! ./js/util/utilFun */ 268), __webpack_require__(/*! react-redux */ 329)))

/***/ },

/***/ 870:
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
	__webpack_require__(/*! ./dashBoardTop.scss */ 871);
	
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
	                            React.createElement('img', { src: __webpack_require__(/*! ../../../../../assets/images/profile/Nasta.png */ 873) })
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

/***/ 871:
/*!*********************************************************************!*\
  !*** ./js/modules/include/dashBoard/dashBoardTop/dashBoardTop.scss ***!
  \*********************************************************************/
/***/ function(module, exports, __webpack_require__) {

	// style-loader: Adds some css to the DOM by adding a <style> tag
	
	// load the styles
	var content = __webpack_require__(/*! !./../../../../../../~/css-loader!./../../../../../../~/sass-loader!./dashBoardTop.scss */ 872);
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

/***/ 872:
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

/***/ 873:
/*!*****************************************!*\
  !*** ./assets/images/profile/Nasta.png ***!
  \*****************************************/
/***/ function(module, exports, __webpack_require__) {

	module.exports = __webpack_require__.p + "./assets/images/profile/Nasta-7a79320d5a3ce7218410c86397d432de.png";

/***/ },

/***/ 874:
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
	__webpack_require__(/*! ./dashBoardLeftNav.scss */ 875);
	
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
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! react */ 2), __webpack_require__(/*! classnames */ 174), __webpack_require__(/*! ./js/modules/common/customScrollbar/customScrollbar.jsx */ 242), __webpack_require__(/*! react-router */ 778), __webpack_require__(/*! react-intl */ 270)))

/***/ },

/***/ 875:
/*!*****************************************************************************!*\
  !*** ./js/modules/include/dashBoard/dashBoardLeftNav/dashBoardLeftNav.scss ***!
  \*****************************************************************************/
/***/ function(module, exports, __webpack_require__) {

	// style-loader: Adds some css to the DOM by adding a <style> tag
	
	// load the styles
	var content = __webpack_require__(/*! !./../../../../../../~/css-loader!./../../../../../../~/sass-loader!./dashBoardLeftNav.scss */ 876);
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

/***/ 876:
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

/***/ 877:
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
	
	var _dashBoardMainTop = __webpack_require__(/*! ./top/dashBoardMainTop.jsx */ 878);
	
	var _dashBoardMainTop2 = _interopRequireDefault(_dashBoardMainTop);
	
	var _dashBoardMainBottom = __webpack_require__(/*! ./bottom/dashBoardMainBottom.jsx */ 879);
	
	var _dashBoardMainBottom2 = _interopRequireDefault(_dashBoardMainBottom);
	
	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }
	
	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
	
	function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }
	
	function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }
	
	/**
	 * Created by Donghui Huo on 2016/5/10.
	 */
	__webpack_require__(/*! ./dashBoardMain.scss */ 880);
	
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

/***/ 878:
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

/***/ 879:
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

/***/ 880:
/*!***********************************************************************!*\
  !*** ./js/modules/include/dashBoard/dashBoardMain/dashBoardMain.scss ***!
  \***********************************************************************/
/***/ function(module, exports, __webpack_require__) {

	// style-loader: Adds some css to the DOM by adding a <style> tag
	
	// load the styles
	var content = __webpack_require__(/*! !./../../../../../../~/css-loader!./../../../../../../~/sass-loader!./dashBoardMain.scss */ 881);
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

/***/ 881:
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

/***/ 882:
/*!*****************************************************!*\
  !*** ./js/modules/include/dashBoard/dashBoard.scss ***!
  \*****************************************************/
/***/ function(module, exports, __webpack_require__) {

	// style-loader: Adds some css to the DOM by adding a <style> tag
	
	// load the styles
	var content = __webpack_require__(/*! !./../../../../../~/css-loader!./../../../../../~/sass-loader!./dashBoard.scss */ 883);
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

/***/ 883:
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

/***/ 884:
/*!**********************************************!*\
  !*** ./js/modules/index/middleware/index.js ***!
  \**********************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(MiddleWare) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	"use strict";
	
	Object.defineProperty(exports, "__esModule", {
	  value: true
	});
	exports.default = [].concat(MiddleWare.defaultCall);
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! ./js/modules/common/middleware/index.js */ 352)))

/***/ }

});
//# sourceMappingURL=index.js.map